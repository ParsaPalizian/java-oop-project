package com.company.dataadapter;

import com.company.CustomArrayList;
import com.company.db.*;
import com.company.enums.ContentType;
import com.company.enums.SqlCommandType;
import com.company.model.GroupMessage;
import com.company.model.Post;
import com.company.model.Reaction;
import com.company.utility.DateUtility;
import com.company.utility.QueryUtility;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

public class GroupMessageDataAdapter {

    public static final String TABLE_NAME = "group_messages";
    DatabaseHelper dbHelper;


    public GroupMessageDataAdapter() throws SQLException {
        this.dbHelper = new DatabaseHelper();
    }

//    public GroupMessage insert(GroupMessage groupMessage) throws SQLException {
//        if (!dbHelper.isConnected()) {
//            dbHelper = new DatabaseHelper();
//            dbHelper.connect();
//        }
//
//        String sql = String.format(
//                "INSERT INTO group_messages (sender_id,group_id,content) VALUES  ('%d','%d','%s')",
//                groupMessage.getSender().getId(),
//                groupMessage.getGroup().getId(),
//                groupMessage.getContent()
//        );
//        dbHelper.execute(sql);
//        dbHelper.disconnect();
//        dbHelper.setConnection(null);
//        return null;
//    }


    public GroupMessage insert(GroupMessage groupMessage) throws SQLException {

        if (!dbHelper.isConnected()) {
            dbHelper = new DatabaseHelper();
            dbHelper.connect();
        }

        String sql = "INSERT INTO group_messages ";
        ArrayList<String> fields = new ArrayList<>();
        ArrayList<String> values = new ArrayList<>();
        if (groupMessage.getSender().getId() != 0) {
            fields.add("sender_id");
            values.add(groupMessage.getSender().getId() + "");
        }
        if (groupMessage.getReplyId() != 0) {
            fields.add("reply_id");
            values.add(groupMessage.getReplyId() + "");
        }

        if (!groupMessage.getContent().equals("")) {
            fields.add("content");
            values.add("'" + groupMessage.getContent() + "'");
        }

        if (groupMessage.getForwardedFromId() != 0) {
            fields.add("forwarded_from_id");
            values.add(groupMessage.getForwardedFromId() + "");
        }

        if (groupMessage.getGroup().getId() != 0) {
            fields.add("group_id");
            values.add(groupMessage.getGroup().getId() + "");
        }

        sql = String.format("INSERT INTO group_messages (%s) VALUES  (%s)",
                String.join(",", fields.toArray(new String[0])),
                String.join(",", values.toArray(new String[0]))
        );

        int id = dbHelper.insert(sql);
        groupMessage.setId(id);
        dbHelper.disconnect();
        dbHelper.setConnection(null);
        return groupMessage;
    }


    public void delete(int groupContentId) throws SQLException {
        if (!dbHelper.isConnected()) {
            dbHelper = new DatabaseHelper();
            dbHelper.connect();
        }

        String sql = String.format("DELETE from group_messages WHERE id=%s", groupContentId);
        dbHelper.execute(sql);
        dbHelper.disconnect();
        dbHelper.setConnection(null);

    }

    public void delete(String[][] where) throws SQLException {
        if (!dbHelper.isConnected()) {
            dbHelper = new DatabaseHelper();
            dbHelper.connect();
        }

        String sql = String.format("DELETE from %s %s", TABLE_NAME, QueryUtility.createWhereClause(where));
        dbHelper.execute(sql);
        dbHelper.disconnect();
        dbHelper.setConnection(null);
    }


    public GroupMessage update(GroupMessage groupMessage) throws SQLException {
        if (!dbHelper.isConnected()) {
            dbHelper = new DatabaseHelper();
            dbHelper.connect();
        }
        String sql = "";
        if (groupMessage.getContent() != null) {
            sql += String.format("UPDATE %s SET content='%s' WHERE id='%d'", TABLE_NAME, groupMessage.getContent(), groupMessage.getId());
        }

        dbHelper.execute(sql);
        dbHelper.disconnect();
        dbHelper.setConnection(null);
        return groupMessage;
    }

    public ArrayList<Post> findAll() {
        return null;
    }

    public int count(String[] keys, String[] values) throws SQLException {

        if (!dbHelper.isConnected()) {
            dbHelper = new DatabaseHelper();
            dbHelper.connect();
        }

        String sql = "SELECT * FROM " + TABLE_NAME + " ";
        ArrayList<String> keyValues = new ArrayList<>();
        if (keys != null && values != null && keys.length > 0 && values.length > 0) {
            for (int i = 0; i < keys.length; i++) {
                keyValues.add("`" + keys[i] + "` = '" + values[i] + "' ");
            }
            String[] arrKeyValues = keyValues.toArray(new String[0]);
            String whereClause = String.join(" AND ", arrKeyValues);
            sql += " WHERE " + whereClause;
        }

        ResultSet rs = dbHelper.select(sql);
        int cnt = 0;
        while (rs.next()) {
            cnt++;
        }

        dbHelper.disconnect();
        dbHelper.setConnection(null);
        return cnt;

    }

    public CustomArrayList<GroupMessage> find(String[] fields, String[][] joins, String[][] where) throws SQLException, ParseException {

        if (!dbHelper.isConnected()) {
            dbHelper = new DatabaseHelper();
            dbHelper.connect();
        }


        String sql = QueryUtility.create(SqlCommandType.SELECT, TABLE_NAME, fields, joins, where);
        ResultSet rs = dbHelper.select(sql);
        CustomArrayList<GroupMessage> messages = new CustomArrayList<>(GroupMessage::new);
        while (rs.next()) {
            GroupMessage message = new GroupMessage();
            message.setId(rs.getInt("gmid"));
            message.setContent(rs.getString("content"));
            message.setMedia(rs.getString("media"));
            message.getSender().setId(rs.getInt("aid"));
            message.getSender().setFirstName(rs.getString("first_name"));
            message.getSender().setLastName(rs.getString("last_name"));
            message.getSender().setUserName(rs.getString("username"));
            message.getSender().setAvatar(rs.getString("avatar"));
            message.setSentAt(DateUtility.parseStringToLocalDateTime(rs.getString("sent_at")));
            ReactionDataAdapter adapter = new ReactionDataAdapter();
            CustomArrayList<Reaction> reactions = new CustomArrayList<>(Reaction::new);
            reactions = adapter.find(ContentType.GROUP_MESSAGE.toString(), message.getId());
            message.setReactions(reactions);
            messages.add(message);
        }

        dbHelper.disconnect();
        dbHelper.setConnection(null);
        return messages;


    }


}
