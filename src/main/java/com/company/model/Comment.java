package com.company.model;

import com.company.CustomArrayList;
import com.company.Result;
import com.company.dataadapter.CommentDataAdapter;
import com.company.interfaces.Editable;
import com.company.interfaces.Printable;
import com.company.utility.PrintUtility;

import java.sql.SQLException;
import java.time.LocalDateTime;

public class Comment  implements Printable, Editable<Comment> {
    private int id;
    private Account sender;
    private String content;
    private String media;
    private LocalDateTime sentAt;
    private CustomArrayList<Reaction> reactions = new CustomArrayList<>(Reaction::new);

    private int replyId;

    public int getReplyId() {
        return replyId;
    }

    public void setReplyId(int replyId) {
        this.replyId = replyId;
    }

    public Comment(int id, String content) {
        this.id = id;
        this.content = content;
    }

    public Comment() {
    }

    public Comment(Account sender, String content) {
        this.sender = sender;
        this.content = content;
    }

    public CustomArrayList<Reaction> getReactions() {
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

    public Account getSender() {
        return sender;
    }

    public void setSender(Account sender) {
        this.sender = sender;
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

    public static Result<Comment> removeCommentsForPost(int postId) throws SQLException {
        CommentDataAdapter adapter = new CommentDataAdapter();
        adapter.delete(new String[][]{{"post_id", postId + ""}});

        return null;
    }


    public static Result<Comment> remove(int commentId) throws SQLException {

        CommentDataAdapter adapter = new CommentDataAdapter();
        adapter.delete(new String[][]{{"id", commentId + ""}});

        return null;

    }

    public static Result<Comment> edit(int commentId, String content) throws SQLException {
        CommentDataAdapter adapter = new CommentDataAdapter();
        Comment comment = adapter.update(new Comment(commentId, content));
        Result<Comment> result = new Result<>();
        result.setError(false);
        result.setData(comment);
        return result;
    }


    public static Result<Comment> comment(Post post, Comment comment) throws SQLException {
        CommentDataAdapter commentDataAdapter = new CommentDataAdapter();
        comment = commentDataAdapter.insert(comment, post.getId());
        Result<Comment> result = new Result<>();
        result.setData(comment);
        return result;
    }

    public static Result<Comment> reply(Post post, Comment comment) throws SQLException {
        CommentDataAdapter commentDataAdapter = new CommentDataAdapter();
        comment = commentDataAdapter.insert(comment, post.getId());
        Result<Comment> result = new Result<>();
        result.setData(comment);
        return result;
    }

    @Override
    public Result<Comment> edit(String content, boolean... saveToDatabase) throws Exception {
        CommentDataAdapter adapter = new CommentDataAdapter();
        Comment comment = adapter.update(new Comment(this.getId(), content));
        Result<Comment> result = new Result<>();
        result.setError(false);
        result.setData(comment);
        return result;
    }

    @Override
    public Result<Comment> delete() throws Exception {
        CommentDataAdapter adapter = new CommentDataAdapter();
        adapter.delete(new String[][]{{"id", this.getId() + ""}});
        Result<Comment> result = new Result<>();
        result.setError(false);
        result.setData(null);
        return result;

    }

    @Override
    public void printEmptyMessage() {
        PrintUtility.printlnFail("No Comment Found");
        PrintUtility.printlnCommands("(B)ack");

    }

    @Override
    public void printAtFirstPositionMessage() {
        PrintUtility.printlnFail("You Are On First Comment");
    }

    @Override
    public void printAtLastPositionMessage() {
        PrintUtility.printlnFail("You Reached To Last Comment");
    }

    @Override
    public void printContent() {
        PrintUtility.printComment(this);
        PrintUtility.printlnEmojisSummary(Reaction.summarize(this.getReactions()));
    }
}
