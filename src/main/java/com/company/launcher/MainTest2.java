package com.company.launcher;

import com.company.enums.SqlCommandType;
import com.company.utility.QueryUtility;

public class MainTest2 {


    public static void main(String[] args) {

        String sql = QueryUtility.create(
                SqlCommandType.SELECT,
                "followings",
                new String[]{"followings.id", "accounts.id as account_id", "accounts.username", "followings.followed_at"},
                new String[][]{{"accounts", "followings.follower_id", "accounts.id"}},
                new String[][]{{"follower_id", "1"}}
        );

        System.out.println(sql);


    }
}
