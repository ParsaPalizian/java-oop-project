package com.company.model;

import com.company.Result;
import com.company.interfaces.Editable;
import com.company.interfaces.Printable;
import com.company.utility.PrintUtility;

import java.time.LocalDateTime;

public class View   implements Printable, Editable<View> {
    private int id;
    private String messageType;
    private PrivateMessage privateMessage;
    private Account account;
    private LocalDateTime seenAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public PrivateMessage getPrivateMessage() {
        return privateMessage;
    }

    public void setPrivateMessage(PrivateMessage privateMessage) {
        this.privateMessage = privateMessage;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public LocalDateTime getSeenAt() {
        return seenAt;
    }

    public void setSeenAt(LocalDateTime seenAt) {
        this.seenAt = seenAt;
    }

    @Override
    public Result<View> edit(String content, boolean... saveToDatabase) throws Exception {
        return null;
    }

    @Override
    public Result<View> delete() throws Exception {
        return null;
    }

    @Override
    public void printEmptyMessage() {
        PrintUtility.printlnFail("No View Found");
        PrintUtility.printlnCommands("(B)ack");
    }

    @Override
    public void printAtFirstPositionMessage() {
        PrintUtility.printlnFail("You Are On First viewer");
    }

    @Override
    public void printAtLastPositionMessage() {
        PrintUtility.printlnFail("You Reached To Last Viewer");
    }

    @Override
    public void printContent() {
        PrintUtility.printViewer(this);
    }
}
