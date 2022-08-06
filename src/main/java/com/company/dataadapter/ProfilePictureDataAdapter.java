package com.company.dataadapter;

import com.company.CustomArrayList;
import com.company.db.DatabaseHelper;
import com.company.model.Account;
import com.company.model.ProfilePicture;
import com.company.utility.DateUtility;
import com.company.utility.QueryUtility;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

public class ProfilePictureDataAdapter {
    public static final String TABLE_NAME = "profile_pictures";

    DatabaseHelper dbHelper;


    public ProfilePictureDataAdapter() throws SQLException {
        this.dbHelper = new DatabaseHelper();
//        dbHelper.connect();
    }

    public ProfilePicture insert(ProfilePicture profilePicture, Account account) throws SQLException {


        if (!dbHelper.isConnected()) {
            dbHelper = new DatabaseHelper();
            dbHelper.connect();
        }

        String sql = String.format(
                "INSERT INTO %s (account_id,image_address) VALUES  ('%d','%s')",
                TABLE_NAME,
                account.getId(),
                profilePicture.getAddress()
        );

        int id = dbHelper.insert(sql);
        profilePicture.setId(id);
        dbHelper.disconnect();
        dbHelper.setConnection(null);
        return profilePicture;
    }

    public void delete(int profilePictureId) throws SQLException {

        if (!dbHelper.isConnected()) {
            dbHelper = new DatabaseHelper();
            dbHelper.connect();
        }

        String sql = String.format("DELETE from %s WHERE id=%s", TABLE_NAME, profilePictureId);
        dbHelper.execute(sql);
        dbHelper.disconnect();
        dbHelper.setConnection(null);
    }

    //    public Post update(Post post) throws SQLException {
//        if (!dbHelper.isConnected()) {
//            dbHelper = new DatabaseHelper();
//            dbHelper.connect();
//        }
//        String sql = "";
//        if (post.getContent() != null) {
//            sql += String.format("UPDATE posts SET content='%s' WHERE id='%d'", post.getContent(), post.getId());
//        }
//
//        dbHelper.execute(sql);
//        dbHelper.disconnect();
//        dbHelper.setConnection(null);
//        return post;
//    }
//
//    public ArrayList<Post> findAll() {
//        return null;
//    }
//
//    public int count(String[] keys, String[] values) throws SQLException {
//
//        if (!dbHelper.isConnected()) {
//            dbHelper = new DatabaseHelper();
//            dbHelper.connect();
//        }
//
//        String sql = "SELECT * FROM posts " + QueryUtility.createWhereClause(keys,values);
//
//        ResultSet rs = dbHelper.select(sql);
//        int cnt = 0;
//        while (rs.next()) {
//            cnt++;
//        }
//
//        dbHelper.disconnect();
//        dbHelper.setConnection(null);
//        return cnt;
//
//    }
//
    public CustomArrayList<ProfilePicture> find(String[][] where) throws SQLException, ParseException {

        if (!dbHelper.isConnected()) {
            dbHelper = new DatabaseHelper();
            dbHelper.connect();
        }

        String sql = "SELECT * FROM " + TABLE_NAME + " " + QueryUtility.createWhereClause(where);
        ResultSet rs = dbHelper.select(sql);

        CustomArrayList<ProfilePicture> profilePictures = new CustomArrayList<>(ProfilePicture::new);
        while (rs.next()) {
            ProfilePicture profilePicture = new ProfilePicture();
            profilePicture.setId(rs.getInt("id"));
            profilePicture.setAddress(rs.getString("image_address"));
            profilePicture.setSentAt(DateUtility.parseStringToLocalDateTime(rs.getString("sent_at")));
            profilePictures.add(profilePicture);
        }

        dbHelper.disconnect();
        dbHelper.setConnection(null);
        return profilePictures;

    }
}
