package com.company.model;

import com.company.CustomArrayList;
import com.company.Result;
import com.company.dataadapter.GroupDataAdapter;
import com.company.dataadapter.GroupMemberDataAdapter;
import com.company.global.Globals;
import com.company.interfaces.Editable;
import com.company.interfaces.Printable;
import com.company.utility.PrintUtility;

import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

public class Group  implements Printable, Editable<Group> {
    private int id;
    private Account creator;
    private String name;
    private String bio;
    private String profilePicture;
    private String link;
    private CustomArrayList<GroupMember> groupMembers;
    private CustomArrayList<GroupMessage> messages;
    private LocalDateTime createdAt;


    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public ArrayList<GroupMessage> getMessages() {
        if (messages == null) {
            messages = new CustomArrayList<>(GroupMessage::new);
        }
        return messages;
    }

    public void setMessages(CustomArrayList<GroupMessage> messages) {
        this.messages = messages;
    }

    public Group(Account creator, String name, String bio, String profilePicture, String link) {
        this.creator = creator;
        this.name = name;
        this.bio = bio;
        this.profilePicture = profilePicture;
        this.link = link;
    }

    public Group() {
    }

    public static CustomArrayList<Group> getGroups(Account account) throws SQLException, ParseException {

        GroupDataAdapter adapter = new GroupDataAdapter();
        return adapter.find(new String[]{"groups.id as gid", "groups.`name`", "groups.bio", "groups.profile_picture as gpp", "groups.created_at", "accounts.id as aid", "accounts.first_name", "accounts.last_name", "accounts.username", "accounts.phone_number"}, new String[][]{{"group_members", "group_members.group_id", "groups.id"}, {"accounts", "groups.creator_id", "accounts.id"}}, new String[][]{{"member_id", account.getId() + ""}});

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Account getCreator() {
        return creator;
    }

    public void setCreator(Account creator) {
        this.creator = creator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public ArrayList<GroupMember> getGroupMembers() {
        if (groupMembers == null) {
            groupMembers = new CustomArrayList<>(GroupMember::new);
        }
        return groupMembers;
    }

    public void setGroupMembers(CustomArrayList<GroupMember> groupMembers) {
        this.groupMembers = groupMembers;
    }

    public static Result addMember(int userId) {
        return null;
    }

    public static Result removeMember(int userId) {
        return null;
    }

    public static Result promote(int userId) {
        return null;
    }

    public static Result demote(int userId) {
        return null;
    }

    public static Result create(Group group, HashSet<Account> members) throws SQLException {
        GroupDataAdapter groupDataAdapter = new GroupDataAdapter();
        group = groupDataAdapter.insert(group);

        CustomArrayList<GroupMember> groupMembers = new CustomArrayList<>(GroupMember::new);
        GroupMemberDataAdapter adapter = new GroupMemberDataAdapter();
        for (Account member : members) {
            GroupMember groupMember = new GroupMember();
            groupMember.setMember(member);
            groupMember = adapter.insert(groupMember, group.getId());
            groupMembers.add(groupMember);
        }

        group.setGroupMembers(groupMembers);
        Globals.currentAccount.getGroups().add(group);
        return null;
    }

    public static Result addContent(GroupMessage groupMessage, Account account) {
        return null;
    }

    public void removeContent(int userId, int contentId) {

    }

    public static Result delete(Group group) throws SQLException {
        GroupDataAdapter adapter = new GroupDataAdapter();
        adapter.delete(group.getId());


        Result result = new Result();
        result.setError(false);
        return result;
    }


    public static Result leave(Account account, Group group) throws SQLException {

        GroupMember toDelete = null;
        for (GroupMember groupMember : group.getGroupMembers()) {
            if (groupMember.getMember().getId() == account.getId()) {
                GroupMemberDataAdapter adapter = new GroupMemberDataAdapter();
                adapter.delete(groupMember.getId());
                toDelete = groupMember;
            }
        }
        if (toDelete != null) {
            group.getGroupMembers().remove(toDelete);
        }

        Result result = new Result();
        result.setError(false);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        Group group = (Group) o;
        return id == group.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public Result<Group> edit(String content, boolean... saveToDatabase) throws Exception {
        return null;
    }

    @Override
    public Result<Group> delete() throws Exception {
        return null;
    }

    @Override
    public void printEmptyMessage() {
        PrintUtility.printlnFail("No Group Found");
        PrintUtility.printlnCommands("(B)ack");
    }

    @Override
    public void printAtFirstPositionMessage() {
        PrintUtility.printlnFail("You Are On First Group");
    }

    @Override
    public void printAtLastPositionMessage() {
        PrintUtility.printlnFail("You Reached To Last Group");
    }

    @Override
    public void printContent() {
        PrintUtility.printGroup(this);
    }
}
