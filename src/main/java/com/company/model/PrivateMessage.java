package com.company.model;

import com.company.CustomArrayList;
import com.company.Result;
import com.company.dataadapter.PrivateMessageDataAdapter;
import com.company.interfaces.Editable;
import com.company.interfaces.Printable;
import com.company.utility.PrintUtility;

import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Objects;

public class PrivateMessage implements Printable, Editable<PrivateMessage> {
    private int id;
    private Account sender;
    private Account receiver;
    private String type;
    private int forwardedFromId;
    private String content;
    private String media;
    private LocalDateTime sentAt;
    private int replyId;
    private CustomArrayList<Reaction> reactions;

    public CustomArrayList<Reaction> getReactions() {
        if( reactions == null){
            reactions = new CustomArrayList<>(Reaction::new);
        }
        return reactions;
    }

    public void setReactions(CustomArrayList<Reaction> reactions) {
        this.reactions = reactions;
    }

    public int getReplyId() {
        return replyId;
    }

    public void setReplyId(int replyId) {
        this.replyId = replyId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public Account getSender() {
        if(sender==null){
            sender=new Account(0);
        }
        return sender;
    }

    public void setSender(Account sender) {
        this.sender = sender;
    }

    public Account getReceiver() {
        if(receiver==null){
            receiver=new Account(0);
        }
        return receiver;
    }

    public void setReceiver(Account receiver) {
        this.receiver = receiver;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
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

    public LocalDateTime getSentAt() {
        return sentAt;
    }

    public void setSentAt(LocalDateTime sentAt) {
        this.sentAt = sentAt;
    }

    public static Result<CustomArrayList<PrivateMessage>> getAllMessageBetweenUs(Account account) throws SQLException, ParseException {
        PrivateMessageDataAdapter adapter = new PrivateMessageDataAdapter();
        CustomArrayList<PrivateMessage> messages = adapter.find(account.getId());
        Result<CustomArrayList<PrivateMessage>> result = new Result<>();
        result.setError(false);
        result.setData(messages);
        return result;
    }

    public static Result deleteMessage(PrivateMessage privateMessage) throws SQLException {
        PrivateMessageDataAdapter adapter=new PrivateMessageDataAdapter();
        adapter.delete(privateMessage.getId());


        Result result=new Result();
        result.setError(false);
        return result;
    }

    public static Result editMessage(PrivateMessage privateMessage) throws SQLException {
        PrivateMessageDataAdapter adapter=new PrivateMessageDataAdapter();
        adapter.update(privateMessage);

        Result result=new Result();
        result.setError(false);
        return result;
    }

    public static Result sendMessage(PrivateMessage privateMessage) throws SQLException {
        PrivateMessageDataAdapter adapter=new PrivateMessageDataAdapter();
        privateMessage = adapter.insert(privateMessage);
        Result result=new Result();
        result.setError(false);
        result.setData(privateMessage);
        return result;
    }

    public static Result reply(PrivateMessage privateMessage) throws SQLException {
        PrivateMessageDataAdapter adapter=new PrivateMessageDataAdapter();
        privateMessage = adapter.insert(privateMessage);
        Result result=new Result();
        result.setError(false);
        result.setData(privateMessage);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        PrivateMessage that = (PrivateMessage) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public Result<PrivateMessage> edit(String content, boolean... saveToDatabase) throws Exception {
        return null;
    }

    @Override
    public Result<PrivateMessage> delete() throws Exception {
        return null;
    }

    @Override
    public void printEmptyMessage() {
        PrintUtility.printlnFail("No Private message Found");
        PrintUtility.printlnCommands("(B)ack");
    }

    @Override
    public void printAtFirstPositionMessage() {
        PrintUtility.printlnFail("You Are On First Private Message");
    }

    @Override
    public void printAtLastPositionMessage() {
        PrintUtility.printlnFail("You Reached To Private Message");
    }

    @Override
    public void printContent() {
        PrintUtility.printPrivateMessage(this);
        PrintUtility.printlnEmojisSummary( Reaction.summarize(this.getReactions()));
    }
}
