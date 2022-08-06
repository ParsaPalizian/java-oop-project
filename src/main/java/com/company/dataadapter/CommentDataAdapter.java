package com.company.dataadapter;

import com.company.CustomArrayList;
import com.company.db.DatabaseHelper;
import com.company.model.Account;
import com.company.model.Comment;
import com.company.model.Reaction;
import com.company.utility.DateUtility;
import com.company.utility.QueryUtility;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

public class CommentDataAdapter {
    public static final String TABLE_NAME = "comments";

    DatabaseHelper dbHelper;

    public CommentDataAdapter() throws SQLException {
        this.dbHelper = new DatabaseHelper();
//        dbHelper.connect();
    }

    public Comment insert(Comment comment, int post_id) throws SQLException {
        if (!dbHelper.isConnected()) {
            dbHelper = new DatabaseHelper();
            dbHelper.connect();
        }

        ArrayList<String> fields = new ArrayList<>();
        ArrayList<String> values = new ArrayList<>();
        if (comment.getSender().getId() != 0) {
            fields.add("sender_id");
            values.add(comment.getSender().getId() + "");
        }

        if (!comment.getContent().equals("")) {
            fields.add("content");
            values.add("'" + comment.getContent() + "'");
        }

        if (comment.getReplyId() != 0) {
            fields.add("reply_id");
            values.add(comment.getReplyId() + "");
        }

        if (post_id != 0) {
            fields.add("post_id");
            values.add(post_id + "");
        }

        String sql = String.format("INSERT INTO %s (%s) VALUES  (%s)",
                TABLE_NAME,
                String.join(",", fields.toArray(new String[0])),
                String.join(",", values.toArray(new String[0]))
        );

        int id = dbHelper.insert(sql);
        comment.setId(id);
        dbHelper.disconnect();
        dbHelper.setConnection(null);
        return comment;
    }

    public void delete(CommentDataAdapter commentDataAdapter) {

    }

    public Comment update(Comment comment) throws SQLException {

        if (!dbHelper.isConnected()) {
            dbHelper = new DatabaseHelper();
            dbHelper.connect();
        }
        String sql = "";
        if (comment.getContent() != null) {
            sql += String.format("UPDATE %s SET content='%s' WHERE id='%d'", TABLE_NAME, comment.getContent(), comment.getId());
        }

        dbHelper.execute(sql);
        dbHelper.disconnect();
        dbHelper.setConnection(null);
        return comment;

    }

    public ArrayList<CommentDataAdapter> findAll() {
        return null;
    }

    public void delete(String[][] data) throws SQLException {

        if (!dbHelper.isConnected()) {
            dbHelper = new DatabaseHelper();
            dbHelper.connect();
        }

        String sql = "DELETE from " + TABLE_NAME + " " + QueryUtility.createWhereClause(data);
        dbHelper.execute(sql);
        dbHelper.disconnect();
        dbHelper.setConnection(null);
    }


    public CustomArrayList<Comment> find(String[][] where) throws SQLException, ParseException {

        if (!dbHelper.isConnected()) {
            dbHelper = new DatabaseHelper();
            dbHelper.connect();
        }

        String sql = "SELECT * FROM " + TABLE_NAME + " " + QueryUtility.createWhereClause(where);
        ResultSet rs = dbHelper.select(sql);
        CustomArrayList<Comment> comments = new CustomArrayList<>(Comment::new);
        while (rs.next()) {
            Comment comment = new Comment();
            comment.setId(rs.getInt("id"));
            comment.setContent(rs.getString("content"));
            comment.setSentAt(DateUtility.parseStringToLocalDateTime(rs.getString("sent_at")));

            //todo very important match commment to its sender
            comment.setSender(new Account());

            ReactionDataAdapter adapter1 = new ReactionDataAdapter();
            CustomArrayList<Reaction> reactions = adapter1.find("comment", comment.getId());
            comment.setReactions(reactions);

            comments.add(comment);
        }


        dbHelper.disconnect();
        dbHelper.setConnection(null);
        return comments;


    }
}
