package com.company.dataadapter;

import com.company.CustomArrayList;
import com.company.db.DatabaseHelper;
import com.company.enums.SqlCommandType;
import com.company.model.Account;
import com.company.model.Follow;
import com.company.utility.DateUtility;
import com.company.utility.QueryUtility;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

public class FollowDataAdapter {
    public static final String TABLE_NAME = "followings";

    DatabaseHelper dbHelper;

    public FollowDataAdapter() throws SQLException {
        this.dbHelper = new DatabaseHelper();
    }


    public Follow insert(int followerId, int followedId) throws SQLException {
        if (!dbHelper.isConnected()) {
            dbHelper = new DatabaseHelper();
            dbHelper.connect();
        }
        String sql=String.format("insert into %s (follower_id,followed_id) VALUES (%d,%d)",TABLE_NAME,followerId,followedId);
        int id=dbHelper.insert(sql);
        Follow follow=new Follow();
        AccountDataAdapter adapter = new AccountDataAdapter();
        follow.setAccount(adapter.findOne(followerId));
        follow.setId(id);

        dbHelper.disconnect();
        dbHelper.setConnection(null);
        return follow;
    }

    public void delete(int id) throws SQLException {

        if (!dbHelper.isConnected()) {
            dbHelper = new DatabaseHelper();
            dbHelper.connect();
        }
        String sql = "DELETE FROM " + TABLE_NAME + " WHERE id=" + id;
        dbHelper.execute(sql);

    }

    public void delete(int unfollowerId, int unfollowedId) throws SQLException {

        if (!dbHelper.isConnected()) {
            dbHelper = new DatabaseHelper();
            dbHelper.connect();
        }
        String sql = String.format("DELETE FROM %s WHERE follower_id=%s and followed_id=%s", TABLE_NAME, unfollowerId, unfollowedId);
        dbHelper.execute(sql);

    }

    public Account update(FollowDataAdapter followDataAdapter) {
        return null;
    }

    public ArrayList<Follow> findAll() {
        return null;
    }

    public CustomArrayList<Follow> find(String[] fields, String[][] joins, String[][] where) throws SQLException, ParseException {
        if (!dbHelper.isConnected()) {
            dbHelper = new DatabaseHelper();
            dbHelper.connect();
        }


        String sql = QueryUtility.create(SqlCommandType.SELECT, TABLE_NAME, fields, joins, where);
        ResultSet rs = dbHelper.select(sql);
        CustomArrayList<Follow> follows = new CustomArrayList<>(Follow::new);
        while (rs.next()) {
            Follow follow = new Follow();
            follow.setId(rs.getInt("id"));
            follow.setAccount(new Account(rs.getInt("account_id"), rs.getString("accounts.username")));
            follow.setFollowAt(DateUtility.parseStringToLocalDateTime(rs.getString("followings.followed_at")));
            follows.add(follow);
        }

        dbHelper.disconnect();
        dbHelper.setConnection(null);
        return follows;

    }

}
