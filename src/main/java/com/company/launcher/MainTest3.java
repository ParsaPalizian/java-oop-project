package com.company.launcher;

import com.company.dataadapter.FollowDataAdapter;

import java.sql.SQLException;

public class MainTest3 {
    public static void main(String[] args) throws SQLException {


        FollowDataAdapter adapter = new FollowDataAdapter();
        adapter.delete(1);


    }
}
