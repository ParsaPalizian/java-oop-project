package com.company.model;

import com.company.CustomArrayList;
import com.company.Result;
import com.company.dataadapter.FollowDataAdapter;
import com.company.interfaces.Editable;
import com.company.interfaces.Printable;
import com.company.utility.PrintUtility;

import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Objects;

public class Follow  implements Printable, Editable<Follow> {
    private int id;
    private Account account;
    private LocalDateTime followAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public LocalDateTime getFollowAt() {
        return followAt;
    }

    public void setFollowAt(LocalDateTime followAt) {
        this.followAt = followAt;
    }

    public static CustomArrayList<Follow> getFollowers(Account account) throws SQLException, ParseException {
        FollowDataAdapter adapter = new FollowDataAdapter();
        return adapter.find(
                new String[]{"followings.id", "accounts.id as account_id", "accounts.username", "followings.followed_at"},
                new String[][]{{"accounts", "followings.follower_id", "accounts.id"}},
                new String[][]{{"followed_id", account.getId() + ""}}
        );
    }
    public static CustomArrayList<Follow> getFollowings(Account account) throws SQLException, ParseException {
        FollowDataAdapter adapter = new FollowDataAdapter();
        return adapter.find(
                new String[]{"followings.id", "accounts.id as account_id", "accounts.username", "followings.followed_at"},
                new String[][]{{"accounts", "followings.followed_id", "accounts.id"}},
                new String[][]{{"follower_id", account.getId() + ""}}
        );
    }

    public static Result<Follow> follow(Account follower,Account followed) throws SQLException {
        FollowDataAdapter adapter=new FollowDataAdapter();
        Follow follow=adapter.insert(follower.getId(),followed.getId());

        Result<Follow> result=new Result();
        result.setError(false);
        result.setData(follow);
        return result;
    }

    public static Result unfollow(Account unfollower,Account unfollowed) throws SQLException {
        FollowDataAdapter adapter=new FollowDataAdapter();
        adapter.delete(unfollower.getId(),unfollowed.getId());
        adapter.delete(unfollowed.getId(),unfollower.getId());



        Result result=new Result();
        result.setError(false);
        return result;
    }

    @Override
    public Result<Follow> edit(String content, boolean... saveToDatabase) throws Exception {
        return null;
    }

    @Override
    public Result<Follow> delete() throws Exception {
        return null;
    }

    @Override
    public void printEmptyMessage() {
        PrintUtility.printlnFail("No Account Found");
        PrintUtility.printlnCommands("(B)ack");
    }

    @Override
    public void printAtFirstPositionMessage() {
        PrintUtility.printlnFail("You Are On First Account");
    }

    @Override
    public void printAtLastPositionMessage() {
        PrintUtility.printlnFail("You Reached To Last Account");
    }

    @Override
    public void printContent() {
        PrintUtility.printFollow(this);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        Follow follow = (Follow) o;
        return id == follow.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, account, followAt);
    }
}
