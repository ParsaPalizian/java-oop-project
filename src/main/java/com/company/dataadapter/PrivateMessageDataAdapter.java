package com.company.dataadapter;

import com.company.CustomArrayList;
import com.company.db.*;
import com.company.enums.ContentType;
import com.company.model.Account;
import com.company.model.PrivateMessage;
import com.company.model.Reaction;
import com.company.utility.DateUtility;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

public class PrivateMessageDataAdapter {

    public static final String TABLE_NAME = "private_messages";

    DatabaseHelper dbHelper;

    public PrivateMessageDataAdapter() throws SQLException {
        this.dbHelper = new DatabaseHelper();
//        dbHelper.connect();
    }


    public PrivateMessage insert(PrivateMessage privateMessage) throws SQLException {


        if (!dbHelper.isConnected()) {
            dbHelper = new DatabaseHelper();
            dbHelper.connect();
        }

        String sql = "INSERT INTO " + TABLE_NAME + " ";
        ArrayList<String> fields = new ArrayList<>();
        ArrayList<String> values = new ArrayList<>();
        if (privateMessage.getSender().getId() != 0) {
            fields.add("sender_id");
            values.add(privateMessage.getSender().getId() + "");
        }
        if (privateMessage.getReceiver().getId() != 0) {
            fields.add("receiver_id");
            values.add(privateMessage.getReceiver().getId() + "");
        }

        if (!privateMessage.getContent().equals("")) {
            fields.add("content");
            values.add("'" + privateMessage.getContent() + "'");
        }

        if (privateMessage.getForwardedFromId() != 0) {
            fields.add("forwarded_from_id");
            values.add(privateMessage.getForwardedFromId() + "");
        }

        if (privateMessage.getReplyId() != 0) {
            fields.add("reply_id");
            values.add(privateMessage.getReplyId() + "");
        }

        sql = String.format("INSERT INTO %s (%s) VALUES  (%s)",
                TABLE_NAME,
                String.join(",", fields.toArray(new String[0])),
                String.join(",", values.toArray(new String[0]))
        );

        int id = dbHelper.insert(sql);
        privateMessage.setId(id);
        dbHelper.disconnect();
        dbHelper.setConnection(null);
        return privateMessage;
    }

    public void delete(int id) throws SQLException {
        if (!dbHelper.isConnected()) {
            dbHelper = new DatabaseHelper();
            dbHelper.connect();
        }

        String sql = String.format("DELETE from %s WHERE id=%s", TABLE_NAME, id);
        dbHelper.execute(sql);
        dbHelper.disconnect();
        dbHelper.setConnection(null);
    }

    public PrivateMessage update(PrivateMessage privateMessage) throws SQLException {
        if (!dbHelper.isConnected()) {
            dbHelper = new DatabaseHelper();
            dbHelper.connect();
        }
        String sql = "";
        if (privateMessage.getContent() != null) {
            sql += String.format("UPDATE %s SET content='%s' WHERE id=%d", TABLE_NAME, privateMessage.getContent(), privateMessage.getId());
        }

        dbHelper.execute(sql);
        dbHelper.disconnect();
        dbHelper.setConnection(null);
        return privateMessage;
    }

    public CustomArrayList<PrivateMessage> find(int id) throws SQLException, ParseException {
        if (!dbHelper.isConnected()) {
            dbHelper = new DatabaseHelper();
            dbHelper.connect();
        }

        String sql =String.format("SELECT " +
                "private_messages.id," +
                "private_messages.reply_id," +
                "private_messages.forwarded_from_id," +
                "private_messages.content," +
                "private_messages.media," +
                "private_messages.sent_at," +
                "SAC.id AS sid," +
                "SAC.username AS sus," +
                "SAC.avatar AS sav," +
                "RAC.id AS rid," +
                "RAC.username AS rus ," +
                "RAC.avatar AS rav " +
                "FROM  private_messages " +
                "INNER JOIN accounts AS SAC ON SAC.id = private_messages.sender_id " +
                "INNER JOIN accounts AS RAC ON RAC.id = private_messages.receiver_id " +
                "WHERE sender_id = %d OR receiver_id = %d" , id, id);
        ResultSet rs = dbHelper.select(sql);
        CustomArrayList<PrivateMessage> messages = new CustomArrayList<>(PrivateMessage::new);
        while (rs.next()) {
            PrivateMessage privateMessage = new PrivateMessage();
            privateMessage.setId(rs.getInt("id"));
            privateMessage.setSender(new Account(rs.getInt("sid") , rs.getString("sus") , rs.getString("sav") ));
            privateMessage.setReceiver(new Account(rs.getInt("rid"), rs.getString("rus") ,rs.getString("rav") ));
            privateMessage.setContent(rs.getString("content"));
            privateMessage.setMedia(rs.getString("media"));
            privateMessage.setReplyId(rs.getInt("reply_id"));
            privateMessage.setForwardedFromId(rs.getInt("forwarded_from_id"));
            privateMessage.setSentAt(DateUtility.parseStringToLocalDateTime(rs.getString("sent_at")));
            ReactionDataAdapter adapter = new ReactionDataAdapter();
            CustomArrayList<Reaction> reactions = new CustomArrayList<>(Reaction::new);
            reactions = adapter.find(ContentType.PRIVATE_MESSAGE.toString(), privateMessage.getId());
            privateMessage.setReactions(reactions);
            messages.add(privateMessage);
        }

        dbHelper.disconnect();
        dbHelper.setConnection(null);
        return messages;
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


}
