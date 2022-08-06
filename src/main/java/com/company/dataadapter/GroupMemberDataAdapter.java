package com.company.dataadapter;

import com.company.CustomArrayList;
import com.company.db.DatabaseHelper;
import com.company.enums.SqlCommandType;
import com.company.model.Account;
import com.company.model.GroupMember;
import com.company.utility.QueryUtility;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

public class GroupMemberDataAdapter {

    public static final String TABLE_NAME = "group_members";
    DatabaseHelper dbHelper;

    public GroupMemberDataAdapter() throws SQLException {
        this.dbHelper = new DatabaseHelper();
//        dbHelper.connect();
    }

    public GroupMember insert(GroupMember groupMember, int groupId) throws SQLException {
        if (!dbHelper.isConnected()) {
            dbHelper = new DatabaseHelper();
            dbHelper.connect();
        }
        String sql = String.format("INSERT INTO group_members (member_id,group_id) VALUES (%d,%d)",
                groupMember.getMember().getId()
                , groupId
        );

        int id = dbHelper.insert(sql);
        groupMember.setId(id);
        dbHelper.disconnect();
        dbHelper.setConnection(null);
        return groupMember;
    }

    public void delete(int id) throws SQLException {
        if (!dbHelper.isConnected()) {
            dbHelper = new DatabaseHelper();
            dbHelper.connect();
        }

        String sql = String.format("DELETE from %s WHERE id=%s",TABLE_NAME, id);
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


    public CustomArrayList<GroupMember> find(String[] fields, String[][] joins, String[][] where) throws SQLException, ParseException {

        if (!dbHelper.isConnected()) {
            dbHelper = new DatabaseHelper();
            dbHelper.connect();
        }


        String sql = QueryUtility.create(SqlCommandType.SELECT, TABLE_NAME, fields, joins, where);
        ResultSet rs = dbHelper.select(sql);
        CustomArrayList<GroupMember> members = new CustomArrayList<>(GroupMember::new);
        while (rs.next()) {
            Account account1 = new Account(rs.getInt("aid"));
            account1.setFirstName(rs.getString("first_name"));
            account1.setLastName(rs.getString("last_name"));
            account1.setUserName(rs.getString("username"));
            GroupMember groupMember = new GroupMember();
            groupMember.setId(rs.getInt("gmid"));
            groupMember.setAdmin(rs.getBoolean("is_admin"));
            groupMember.setMember(account1);
            members.add(groupMember);
        }

        dbHelper.disconnect();
        dbHelper.setConnection(null);
        return members;


    }


    public Account update(GroupMember groupMember) {
        return null;
    }

    public ArrayList<GroupMember> findAll() {
        return null;
    }
}
