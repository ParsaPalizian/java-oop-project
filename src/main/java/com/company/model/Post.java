package com.company.model;

import com.company.CustomArrayList;
import com.company.Result;
import com.company.dataadapter.PostDataAdapter;
import com.company.interfaces.Editable;
import com.company.interfaces.Printable;
import com.company.utility.PrintUtility;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

public class Post implements Printable, Editable<Post> {
    private int id;
    private Account account;
    private String content;
    private String media;
    private LocalDateTime sentAt;
    private CustomArrayList<Comment> comments;
    private CustomArrayList<Reaction> reactions = new CustomArrayList<>(Reaction::new);



    public Post(int id, String content) {
        this.id = id;
        this.content = content;
    }

    public Post() {
    }


    public ArrayList<Reaction> getReactions() {
        return reactions;
    }

    public void setReactions(CustomArrayList<Reaction> reactions) {
        this.reactions = reactions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Account getAccount() {
        if (account == null) {
            account = new Account();
        }
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
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

    public CustomArrayList<Comment> getComments() {
        if (comments == null) {
            comments = new CustomArrayList<>(Comment::new);
        }
        return comments;
    }

    public void setComments(CustomArrayList<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        return this.hashCode() == o.hashCode();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    public Post clone() {

        Post p1 = new Post();
        p1.setId(this.id);
        p1.setContent(this.content);
        p1.setMedia(this.media);
        return p1;

    }

    public static Result<Post> sendPost(Post post) throws SQLException {
        PostDataAdapter postDataAdapter = new PostDataAdapter();
        post = postDataAdapter.insert(post).clone();
        Result<Post> result = new Result<>();
        result.setData(post);
        result.setError(false);
        return result;
    }

    public static Result<Post> editPost(int postId, String content) throws SQLException {
        PostDataAdapter postDataAdapter = new PostDataAdapter();
        Post post = postDataAdapter.update(new Post(postId, content));
        Result<Post> result = new Result<>();
        result.setError(false);
        result.setData(post);
        return result;
    }

    @Override
    public Result<Post> edit(String content, boolean... saveToDatabase) throws Exception {
        Result<Post> result = new Result<>();
        boolean toDB = false;
        if (saveToDatabase.length == 1) {
            toDB = saveToDatabase[0];
        } else if (saveToDatabase.length > 1) {
            throw new Exception("Too Many Arguments");
        }
        if (toDB) {
            PostDataAdapter postDataAdapter = new PostDataAdapter();
            Post post = postDataAdapter.update(new Post(this.getId(), content));
            this.setContent(content);
            result.setError(false);
        }
        return result;
    }

    public static Result<Post> deletePost(int postId) throws SQLException {

        PostDataAdapter postDataAdapter = new PostDataAdapter();
        postDataAdapter.delete(postId);
        Comment.removeCommentsForPost(postId);
        Reaction.removeReactionForPost(postId);
        Result<Post> result = new Result<>();
        result.setError(false);
        result.setData(null);
        return result;
    }


    public Result<Post> delete() throws SQLException {

        PostDataAdapter postDataAdapter = new PostDataAdapter();
        postDataAdapter.delete(this.getId());
        Comment.removeCommentsForPost(this.getId());
        Reaction.removeReactionForPost(this.getId());
        Result<Post> result = new Result<>();
        result.setError(false);
        result.setData(null);
        return result;
    }


    @Override
    public void printEmptyMessage() {
        PrintUtility.printlnFail("No Post Found");
        PrintUtility.printlnCommands("(B)ack");
    }

    @Override
    public void printAtFirstPositionMessage() {
        PrintUtility.printlnFail("You Are On First Post");
    }

    @Override
    public void printAtLastPositionMessage() {
        PrintUtility.printlnFail("You Reached To Last Post");
    }

    @Override
    public void printContent() {
        PrintUtility.printPost(this);
        PrintUtility.printlnEmojisSummary(Reaction.summarize(this.getReactions()));
    }
}
