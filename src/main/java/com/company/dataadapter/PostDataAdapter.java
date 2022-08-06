package com.company.dataadapter;

import com.company.CustomArrayList;
import com.company.db.DatabaseHelper;
import com.company.enums.SqlCommandType;
import com.company.model.Account;
import com.company.model.Comment;
import com.company.model.Post;
import com.company.model.Reaction;
import com.company.utility.DateUtility;
import com.company.utility.QueryUtility;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

public class PostDataAdapter {
    public static final String TABLE_NAME = "posts";
    DatabaseHelper dbHelper;


    public PostDataAdapter() throws SQLException {
        this.dbHelper = new DatabaseHelper();
//        dbHelper.connect();
    }

    public Post insert(Post post) throws SQLException {


        if (!dbHelper.isConnected()) {
            dbHelper = new DatabaseHelper();
            dbHelper.connect();
        }

        String sql = String.format(
                "INSERT INTO %s (account_id,media,content) VALUES  ('%d','%s','%s')",
                TABLE_NAME,
                post.getAccount().getId(),
                post.getMedia(),
                post.getContent()
        );

        int id = dbHelper.insert(sql);
        post.setId(id);
        dbHelper.disconnect();
        dbHelper.setConnection(null);
        return post;
    }

    public void delete(int postId) throws SQLException {

        if (!dbHelper.isConnected()) {
            dbHelper = new DatabaseHelper();
            dbHelper.connect();
        }

        String sql = String.format("DELETE from %s WHERE id=%s", TABLE_NAME, postId);
        dbHelper.execute(sql);
        dbHelper.disconnect();
        dbHelper.setConnection(null);
    }

    public Post update(Post post) throws SQLException {
        if (!dbHelper.isConnected()) {
            dbHelper = new DatabaseHelper();
            dbHelper.connect();
        }
        String sql = "";
        if (post.getContent() != null) {
            sql += String.format("UPDATE %s SET content='%s' WHERE id='%d'", TABLE_NAME, post.getContent(), post.getId());
        }

        dbHelper.execute(sql);
        dbHelper.disconnect();
        dbHelper.setConnection(null);
        return post;
    }

    public ArrayList<Post> findAll() {
        return null;
    }

    public int count(String[][] where) throws SQLException {

        if (!dbHelper.isConnected()) {
            dbHelper = new DatabaseHelper();
            dbHelper.connect();
        }

        String sql = "SELECT * FROM " + TABLE_NAME + " " + QueryUtility.createWhereClause(where);
        ResultSet rs = dbHelper.select(sql);
        int cnt = 0;
        while (rs.next()) {
            cnt++;
        }

        dbHelper.disconnect();
        dbHelper.setConnection(null);
        return cnt;

    }

    public CustomArrayList<Post> find(String[][] where) throws SQLException, ParseException {

        if (!dbHelper.isConnected()) {
            dbHelper = new DatabaseHelper();
            dbHelper.connect();
        }

        String sql = "SELECT * FROM " + TABLE_NAME + " " + QueryUtility.createWhereClause(where);
        ResultSet rs = dbHelper.select(sql);

        CustomArrayList<Post> posts = new CustomArrayList<>(Post::new);
        while (rs.next()) {
            Post post = new Post();
            post.setId(rs.getInt("id"));
            post.setContent(rs.getString("content"));
            post.setMedia(rs.getString("media"));
            post.setSentAt(DateUtility.parseStringToLocalDateTime(rs.getString("sent_at")));
            CommentDataAdapter adapter = new CommentDataAdapter();
            CustomArrayList<Comment> comments = adapter.find(new String[][]{{"post_id", post.getId() + ""}});
            post.setComments(comments);
            ReactionDataAdapter adapter1 = new ReactionDataAdapter();
            CustomArrayList<Reaction> reactions = adapter1.find("post", post.getId());
            post.setReactions(reactions);

            posts.add(post);
        }

        dbHelper.disconnect();
        dbHelper.setConnection(null);
        return posts;


    }


    public CustomArrayList<Post> find(int id) throws SQLException, ParseException {

        if (!dbHelper.isConnected()) {
            dbHelper = new DatabaseHelper();
            dbHelper.connect();
        }

        String sql = QueryUtility.create(
                SqlCommandType.SELECT,
                TABLE_NAME,
                new String[]{
                        "posts.id as pid",
                        "posts.content",
                        "posts.media",
                        "posts.sent_at",
                        "accounts.id as aid",
                        "accounts.username"
                },
                new String[][]{
                        {"accounts", "posts.account_id", "accounts.id"}
                },
                null
        );

        sql += String.format(" WHERE account_id in (select followed_id from followings WHERE follower_id = %d) ORDER BY posts.sent_at DESC", id);

        ResultSet rs = dbHelper.select(sql);

        CustomArrayList<Post> posts = new CustomArrayList<>(Post::new);
        while (rs.next()) {
            Post post = new Post();
            post.setId(rs.getInt("pid"));
            post.setContent(rs.getString("content"));
            post.setMedia(rs.getString("media"));
            Account account = new Account(rs.getInt("aid"), rs.getString("username"));
            post.setAccount(account);
            post.setSentAt(DateUtility.parseStringToLocalDateTime(rs.getString("sent_at")));
            CommentDataAdapter adapter = new CommentDataAdapter();
            CustomArrayList<Comment> comments = adapter.find(new String[][]{{"post_id", post.getId() + ""}});
            post.setComments(comments);

            ReactionDataAdapter adapter1 = new ReactionDataAdapter();
            CustomArrayList<Reaction> reactions = adapter1.find("post", post.getId());
            post.setReactions(reactions);

            posts.add(post);
        }

        dbHelper.disconnect();
        dbHelper.setConnection(null);
        return posts;
    }

}
