package com.company.model;

import com.company.CustomArrayList;
import com.company.Result;
import com.company.dataadapter.GroupMessageDataAdapter;
import com.company.enums.GroupMessageType;
import com.company.interfaces.Editable;
import com.company.interfaces.Printable;
import com.company.utility.PrintUtility;

import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

public class GroupMessage  implements Printable, Editable<GroupMessage> {
    private int id;
    private Group group;
    private Account sender;
    private int replyId;
    private GroupMessageType type;
    private int forwardedFromId;
    private String content;
    private String media;
    private boolean seen;
    private boolean edited;
    private LocalDateTime sentAt;
    private CustomArrayList<Reaction> reactions;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Account getSender() {
        if (sender == null) {
            sender = new Account(0);
        }
        return sender;
    }

    public void setSender(Account sender) {

        this.sender = sender;
    }

    public int getReplyId() {
        return replyId;
    }

    public void setReplyId(int replyId) {
        this.replyId = replyId;
    }

    public GroupMessageType getType() {
        return type;
    }

    public void setType(GroupMessageType type) {
        this.type = type;
    }

    public int getForwardedFromId() {
        return forwardedFromId;
    }

    public void setForwardedFromId(int forwardedFromId) {
        this.forwardedFromId = forwardedFromId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public boolean isSeen() {
        return seen;
    }

    public void setSeen(boolean seen) {
        this.seen = seen;
    }

    public boolean isEdited() {
        return edited;
    }

    public void setEdited(boolean edited) {
        this.edited = edited;
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }

    public void setSentAt(LocalDateTime sentAt) {
        this.sentAt = sentAt;
    }

    public ArrayList<Reaction> getReactions() {
        if( reactions == null){
            reactions = new CustomArrayList<>(Reaction::new);
        }
        return reactions;
    }

    public void setReactions(CustomArrayList<Reaction> reactions) {
        this.reactions = reactions;
    }



    public static Result reply(GroupMessage groupMessage) throws SQLException {
        GroupMessageDataAdapter adapter=new GroupMessageDataAdapter();
        groupMessage = adapter.insert(groupMessage);
        Result result=new Result();
        result.setError(false);
        result.setData(groupMessage);
        return result;
    }

    public static Result sendMessage(GroupMessage message) throws SQLException {
        GroupMessageDataAdapter adapter=new GroupMessageDataAdapter();
        message = adapter.insert(message);
        Result result=new Result();
        result.setError(false);
        result.setData(message);
        return result;
    }



    public static CustomArrayList<GroupMessage> getGroupMessages(int groupId) throws SQLException, ParseException {
        GroupMessageDataAdapter adapter = new GroupMessageDataAdapter();
        return  adapter.find(
                new String[]{
                        "group_messages.id as gmid",
                        "group_messages.content",
                        "group_messages.media",
                        "group_messages.sent_at",
                        "accounts.id as aid",
                        "accounts.username",
                        "accounts.avatar",
                        "accounts.first_name",
                        "accounts.last_name"
                },
                new String[][] {
                        {"accounts","accounts.id","sender_id"},
                        {"groups","groups.id","group_id"}
                },
                new String[][] {{"group_id" ,groupId+ ""}}
        );
    }






    public static Result delete(GroupMessage groupMessage) throws SQLException {
        GroupMessageDataAdapter groupMessageDataAdapter=new GroupMessageDataAdapter();
        groupMessageDataAdapter.delete(groupMessage.getId());

        Result result=new Result();
        result.setError(false);
        return result;
    }

    public static Result edit(GroupMessage groupMessage) throws SQLException {
        GroupMessageDataAdapter adapter=new GroupMessageDataAdapter();
        adapter.update(groupMessage);

        Result result=new Result();
        result.setError(false);
        return result;
    }

    @Override
    public boolean equals(Object o) {

        return id == ((GroupMessage)o).id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public Result<GroupMessage> edit(String content, boolean... saveToDatabase) throws Exception {
        return null;
    }

    @Override
    public Result<GroupMessage> delete() throws Exception {
        return null;
    }

    @Override
    public void printEmptyMessage() {
        PrintUtility.printlnFail("No Group Message Found");
        PrintUtility.printlnCommands("(B)ack");
    }

    @Override
    public void printAtFirstPositionMessage() {
        PrintUtility.printlnFail("You Are On First Group Message");
    }

    @Override
    public void printAtLastPositionMessage() {
        PrintUtility.printlnFail("You Reached To Last Group message");
    }

    @Override
    public void printContent() {
        PrintUtility.printGroupMessage(this);
    }
}
