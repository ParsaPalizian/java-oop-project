package com.company.model;

import com.company.CustomArrayList;
import com.company.Result;
import com.company.dataadapter.ReactionDataAdapter;
import com.company.enums.ContentType;
import com.company.enums.ReactionType;
import com.company.interfaces.Editable;
import com.company.interfaces.Printable;
import com.company.utility.PrintUtility;

import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Objects;

public class Reaction  implements Printable, Editable<Reaction> {
    private int id;
    private String contentType;
    private ReactionType type;
    private LocalDateTime reactedAt;
    private Account sender;


    public Account getSender() {
        return sender;
    }

    public void setSender(Account sender) {
        this.sender = sender;
    }

    public Reaction() {
    }

    public Reaction(ReactionType type) {
        this.type = type;
    }


    public Reaction(int id, String contentType, ReactionType type, Account sender) {
        this.id = id;
        this.contentType = contentType;
        this.type = type;
        this.sender = sender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }


    public ReactionType getType() {
        return type;
    }

    public void setType(ReactionType type) {
        this.type = type;
    }

    public LocalDateTime getReactedAt() {
        return reactedAt;
    }

    public void setReactedAt(LocalDateTime reactedAt) {
        this.reactedAt = reactedAt;
    }


    public static Result<Reaction> sendReaction(Account account, ContentType contentType, Reaction reaction, int id) throws SQLException {
        ReactionDataAdapter adapter = new ReactionDataAdapter();
        reaction = adapter.insert(account.getId(), contentType.toString(), id, reaction);
        Result<Reaction> result = new Result<>();
        result.setData(reaction);
        result.setError(false);
        return result;
    }

    public static Result removeReactionForPost(int postId) throws SQLException {
        ReactionDataAdapter adapter = new ReactionDataAdapter();
        adapter.delete(new String[][]{{"content_type", ContentType.POST.toString()}, {"content_id", postId + ""}});
        return null;
    }


    public static Result removeReactionForComment(int commentId) throws SQLException {
        ReactionDataAdapter adapter = new ReactionDataAdapter();
        adapter.delete(new String[][]{{"content_type", ContentType.COMMENT.toString()}, {"content_id", commentId + ""}});
        return null;
    }


    public static ArrayList<Reaction> getReactionsForPost(int postId) throws SQLException, ParseException {

        ReactionDataAdapter adapter1 = new ReactionDataAdapter();
        ArrayList<Reaction> reactions = adapter1.find("post", postId);
        return reactions;
    }

    public static ArrayList<Reaction> getReactionsForComment(int commentId) throws SQLException, ParseException {

        ReactionDataAdapter adapter1 = new ReactionDataAdapter();
        ArrayList<Reaction> reactions = adapter1.find("comment", commentId);
        return reactions;

    }

    public static CustomArrayList<Reaction> getReactions(String contentType, int commentId) throws SQLException, ParseException {
        ReactionDataAdapter adapter1 = new ReactionDataAdapter();
        CustomArrayList<Reaction> reactions = adapter1.find(contentType, commentId);
        return reactions;
    }


    public static LinkedHashMap<ReactionType, Integer> summarize(ArrayList<Reaction> reactions) {

        LinkedHashMap<ReactionType, Integer> reacts = new LinkedHashMap<>();
        reacts.put(ReactionType.LAUGH, 0);
        reacts.put(ReactionType.HEART, 0);
        reacts.put(ReactionType.LIKE, 0);
        reacts.put(ReactionType.DISLIKE, 0);
        reacts.put(ReactionType.POKER_FACE, 0);
        reacts.put(ReactionType.RAGE, 0);
        reacts.put(ReactionType.CRY, 0);
        reacts.put(ReactionType.DISGUSTING, 0);
        reacts.put(ReactionType.FIRE, 0);
        for (Reaction reaction : reactions) {
            int a = reacts.get(reaction.getType());
            a++;
            reacts.put(reaction.getType(), a);
        }
        return reacts;
    }


    public static Result<Reaction> react(Account account, Reaction reaction, Comment comment) throws SQLException, ParseException {
        Result<Reaction> result = Reaction.sendReaction(account, ContentType.COMMENT, reaction, comment.getId());
        Reaction reaction1 = (Reaction) result.getData();
        comment.setReactions(Reaction.getReactions(ContentType.COMMENT.toString(), comment.getId()));
        return result;
    }

    public static Result<Reaction> react(Account account, Reaction reaction, Post post) throws SQLException, ParseException {
        Result<Reaction> result = Reaction.sendReaction(account, ContentType.POST, reaction, post.getId());
        Reaction reaction1 = (Reaction) result.getData();
        post.setReactions(Reaction.getReactions(ContentType.POST.toString(), post.getId()));
        return result;
    }

    public static Result<Reaction> react(Account account, Reaction reaction, PrivateMessage privateMessage) throws SQLException, ParseException {
        Result<Reaction> result = Reaction.sendReaction(account, ContentType.PRIVATE_MESSAGE, reaction, privateMessage.getId());
        Reaction reaction1 = (Reaction) result.getData();
        privateMessage.setReactions(Reaction.getReactions(ContentType.PRIVATE_MESSAGE.toString(), privateMessage.getId()));
        return result;
    }

    public static Result<Reaction> react(Account account, Reaction reaction, GroupMessage groupMessage) throws SQLException, ParseException {
        Result<Reaction> result = Reaction.sendReaction(account, ContentType.GROUP_MESSAGE, reaction, groupMessage.getId());
        Reaction reaction1 = (Reaction) result.getData();
        groupMessage.setReactions(Reaction.getReactions(ContentType.GROUP_MESSAGE.toString(), groupMessage.getId()));
        return result;
    }





    @Override
    public boolean equals(Object o) {

        Reaction reaction = (Reaction) o;
        return id == reaction.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public Result<Reaction> edit(String content, boolean... saveToDatabase) throws Exception {
        return null;
    }

    @Override
    public Result<Reaction> delete() throws Exception {
        return null;
    }

    @Override
    public void printEmptyMessage() {
        PrintUtility.printlnFail("No Reaction Found");
        PrintUtility.printlnCommands("(B)ack");
    }

    @Override
    public void printAtFirstPositionMessage() {
        PrintUtility.printlnFail("You Are On First Reaction");
    }

    @Override
    public void printAtLastPositionMessage() {
        PrintUtility.printlnFail("You Reached To Last Reaction");
    }

    @Override
    public void printContent() {
        PrintUtility.printReaction(this);
    }
}
