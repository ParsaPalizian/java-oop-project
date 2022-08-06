package com.company.dataadapter;

import com.company.CustomArrayList;
import com.company.db.DatabaseHelper;
import com.company.enums.SqlCommandType;
import com.company.model.Account;
import com.company.model.Group;
import com.company.model.GroupMember;
import com.company.model.GroupMessage;
import com.company.utility.DateUtility;
import com.company.utility.QueryUtility;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

public class GroupDataAdapter {
    public static final String TABLE_NAME = "groups";

    DatabaseHelper dbHelper;

    public GroupDataAdapter() throws SQLException {
        this.dbHelper = new DatabaseHelper();
    }

    public Group insert(Group group) throws SQLException {

        if (!dbHelper.isConnected()) {
            dbHelper = new DatabaseHelper();
            dbHelper.connect();
        }

        String sql = String.format("INSERT INTO %s (creator_id,`name`,bio,profile_picture,link) VALUES ('%d','%s','%s','%s','%s')",
                TABLE_NAME,
                group.getCreator().getId(),
                group.getName(),
                group.getBio(),
                group.getProfilePicture(),
                group.getLink()
        );
        int id = dbHelper.insert(sql);
        group.setId(id);
        dbHelper.disconnect();
        dbHelper.setConnection(null);
        return group;
    }

    public void delete(int Id) throws SQLException {

        if (!dbHelper.isConnected()) {
            dbHelper = new DatabaseHelper();
            dbHelper.connect();
        }

        String sql1 = String.format("DELETE from %s WHERE id=%d", TABLE_NAME, Id);
        dbHelper.execute(sql1);
        dbHelper.disconnect();
        dbHelper.setConnection(null);
        new GroupMemberDataAdapter().delete(new String[][]{{"group_id", Id + ""}});
        new GroupMessageDataAdapter().delete(new String[][]{{"group_id", Id + ""}});
    }

    public Group update(Group group) throws SQLException {
        if (!dbHelper.isConnected()) {
            dbHelper = new DatabaseHelper();
            dbHelper.connect();
        }

        String sql = String.format("UPDATE %s SET  creator_id= %d ,`name`= '%s',bio = '%s',profile_picture = '%s',link = '%s' WHERE id = %d ",
                TABLE_NAME,
                group.getCreator().getId(),
                group.getName(),
                group.getBio(),
                group.getProfilePicture(),
                group.getLink(),
                group.getId()
        );
        dbHelper.execute(sql);
        dbHelper.disconnect();
        dbHelper.setConnection(null);
        return group;

    }

    public ArrayList<GroupDataAdapter> findAll() {
        return null;
    }

    public CustomArrayList<Group> find(String[] fields, String[][] joins, String[][] where) throws SQLException, ParseException {
        if (!dbHelper.isConnected()) {
            dbHelper = new DatabaseHelper();
            dbHelper.connect();
        }

        String sql = QueryUtility.create(SqlCommandType.SELECT_DISTINCT, TABLE_NAME, fields, joins, where);
        ResultSet rs = dbHelper.select(sql);
        CustomArrayList<Group> groups = new CustomArrayList<>(Group::new);
        while (rs.next()) {
            Group group = new Group();
            group.setId(rs.getInt("gid"));
            group.setName(rs.getString("name"));
            group.setBio(rs.getString("bio"));
            group.setProfilePicture(rs.getString("gpp"));
            group.setCreatedAt(DateUtility.parseStringToLocalDateTime(rs.getString("created_at")));
            Account account = new Account(rs.getInt("aid"));
            account.setUserName(rs.getString("username"));
            account.setFirstName(rs.getString("first_name"));
            account.setLastName(rs.getString("last_name"));
            group.setCreator(account);


//            String sql1 = QueryUtility.create(
//                    SqlCommandType.SELECT,
//                    "accounts",
//                    new String[]{
//                            "group_members.id as gmid",
//                            "accounts.id as aid",
//                            "accounts.username",
//                            "accounts.first_name",
//                            "accounts.last_name",
//                            "group_members.is_admin",
//                    },
//                    new String[][]{{"group_members", "group_members.member_id", "accounts.id"}},
//                    new String[][]{{"group_id", group.getId() + ""}}
//            );
//
//            ResultSet rs1 = dbHelper.select(sql1);
//            while (rs1.next()) {
//                Account account1 = new Account(rs1.getInt("aid"));
//                account1.setFirstName(rs1.getString("first_name"));
//                account1.setLastName(rs1.getString("last_name"));
//                account1.setUserName(rs1.getString("username"));
//                GroupMember groupMember = new GroupMember();
//                groupMember.setId(rs1.getInt("gmid"));
//                groupMember.setAdmin(rs1.getBoolean("is_admin"));
//                groupMember.setMember(account1);
//                group.getGroupMembers().add(groupMember);
//            }
            //TODO I SHOULD CHECK THE NEW CODE
            group.setGroupMembers(GroupMember.getGroupMembers(group.getId()));
            //END

            group.setMessages(GroupMessage.getGroupMessages(group.getId()));

            groups.add(group);
        }

        dbHelper.disconnect();
        dbHelper.setConnection(null);
        return groups;

    }


}
