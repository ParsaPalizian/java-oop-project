package com.company.model;

import com.company.CustomArrayList;
import com.company.Result;
import com.company.dataadapter.GroupMemberDataAdapter;
import com.company.interfaces.Editable;
import com.company.interfaces.Printable;
import com.company.utility.PrintUtility;

import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Objects;

public class GroupMember  implements Printable, Editable<GroupMember> {
    private int id;
    private Account member;
    private boolean admin;
    private LocalDateTime joinedAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Account getMember() {
        return member;
    }

    public void setMember(Account member) {
        this.member = member;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public LocalDateTime getJoinedAt() {
        return joinedAt;
    }

    public void setJoinedAt(LocalDateTime joinedAt) {
        this.joinedAt = joinedAt;
    }

    public static Result kick(GroupMember groupMember) throws SQLException {
        GroupMemberDataAdapter groupMemberDataAdapter = new GroupMemberDataAdapter();
        groupMemberDataAdapter.delete(groupMember.getId());

        Result result = new Result();
        result.setError(false);
        return result;
    }

    public static CustomArrayList<GroupMember> getGroupMembers(int groupId) throws SQLException, ParseException {
        GroupMemberDataAdapter adapter = new GroupMemberDataAdapter();
        return adapter.find(
                new String[]{
                        "group_members.id as gmid",
                        "accounts.id as aid",
                        "accounts.username",
                        "accounts.first_name",
                        "accounts.last_name",
                        "group_members.is_admin",
                },
                new String[][]{{"accounts", "group_members.member_id", "accounts.id"}},
                new String[][]{{"group_id", groupId + ""}}
        );
    }


    @Override
    public boolean equals(Object o) {
        return id == ((GroupMember) o).id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public Result<GroupMember> edit(String content, boolean... saveToDatabase) throws Exception {
        return null;
    }

    @Override
    public Result<GroupMember> delete() throws Exception {
        return null;
    }

    @Override
    public void printEmptyMessage() {
        PrintUtility.printlnFail("There Is No Group Member");
        PrintUtility.printlnCommands("(B)ack");
    }

    @Override
    public void printAtFirstPositionMessage() {
        PrintUtility.printlnFail("You Are On First Member");
    }

    @Override
    public void printAtLastPositionMessage() {
        PrintUtility.printlnFail("You Reached To Last Member");
    }

    @Override
    public void printContent() {
        PrintUtility.printGroupMember(this);
    }
}
