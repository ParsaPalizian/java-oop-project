package com.company.dataadapter;

import com.company.CustomArrayList;
import com.company.db.DatabaseHelper;
import com.company.model.Account;
import com.company.model.Request;
import com.company.utility.DateUtility;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

public class RequestDataAdapter {

    public static final String TABLE_NAME = "requests";

    DatabaseHelper dbHelper;

    public RequestDataAdapter() throws SQLException {
        this.dbHelper = new DatabaseHelper();
    }


    public Request insert(Request request) throws SQLException {
        if (!dbHelper.isConnected()) {
            dbHelper = new DatabaseHelper();
            dbHelper.connect();
        }

        String sql = "INSERT INTO " + TABLE_NAME + " ";
        ArrayList<String> fields = new ArrayList<>();
        ArrayList<String> values = new ArrayList<>();
        if (request.getFrom().getId() != 0) {
            fields.add("`from`");
            values.add(request.getFrom().getId() + "");
        }
        if (request.getTo().getId() != 0) {
            fields.add("`to`");
            values.add(request.getTo().getId() + "");
        }

        sql = String.format("INSERT INTO %s (%s) VALUES  (%s)",
                TABLE_NAME,
                String.join(",", fields.toArray(new String[0])),
                String.join(",", values.toArray(new String[0]))
        );

        int id = dbHelper.insert(sql);
        request.setId(id);
        dbHelper.disconnect();
        dbHelper.setConnection(null);
        return request;


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

    public Request update(Request request) throws SQLException {
        if (!dbHelper.isConnected()) {
            dbHelper = new DatabaseHelper();
            dbHelper.connect();
        }
        String sql = String.format("UPDATE %s SET content='%s' WHERE id=%d", TABLE_NAME, request.getId());

        dbHelper.execute(sql);
        dbHelper.disconnect();
        dbHelper.setConnection(null);
        return request;

    }


    public CustomArrayList<Request> find(int id) throws SQLException, ParseException {
        if (!dbHelper.isConnected()) {
            dbHelper = new DatabaseHelper();
            dbHelper.connect();
        }

        String sql = String.format("SELECT requests.id AS rid,requests.sent_at,accounts.id as aid,accounts.username from accounts INNER JOIN requests ON accounts.id=requests.`from` WHERE requests.`to` = %d ", id);

        ResultSet rs = dbHelper.select(sql);
        CustomArrayList<Request> requests = new CustomArrayList<Request>(Request::new);
        while (rs.next()) {
            Request request = new Request();
            request.setId(rs.getInt("rid"));
            request.setFrom(new Account(rs.getInt("aid"), rs.getString("username")));
            request.setTo(new Account(id));
            request.setSentAt(DateUtility.parseStringToLocalDateTime(rs.getString("sent_at")));
            requests.add(request);
        }

        dbHelper.disconnect();
        dbHelper.setConnection(null);
        return requests;
    }




}
