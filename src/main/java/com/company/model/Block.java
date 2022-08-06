package com.company.model;

import com.company.CustomArrayList;
import com.company.Result;
import com.company.dataadapter.BlockDataAdaptor;
import com.company.interfaces.Editable;
import com.company.interfaces.Printable;
import com.company.utility.PrintUtility;

import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Objects;

public class Block   implements Printable, Editable<Block> {
    private int id;
    private Account blocker;
    private Account blocked;
    private LocalDateTime blockedAt;

    public Block(Account blocker, Account blocked) {
        this.blocker = blocker;
        this.blocked = blocked;
    }

    public Block() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Account getBlocker() {
        return blocker;
    }

    public void setBlocker(Account blocker) {
        this.blocker = blocker;
    }

    public Account getBlocked() {
        return blocked;
    }

    public void setBlocked(Account blocked) {
        this.blocked = blocked;
    }

    public LocalDateTime getBlockedAt() {
        return blockedAt;
    }

    public void setBlockedAt(LocalDateTime blockedAt) {
        this.blockedAt = blockedAt;
    }

    public static CustomArrayList<Block> getBlockedS(Account account) throws SQLException, ParseException {
        BlockDataAdaptor adaptor=new BlockDataAdaptor();
        return adaptor.find(
                new String[]{"blocks.id", "accounts.id as account_id", "accounts.username", "blocks.blocked_at"},
                new String[][]{{"accounts", "blocks.blocked_id", "accounts.id"}},
                new String[][]{{"blocker_id", account.getId() + ""}}
        );
    }

    public static Result block(Block block) throws SQLException {

        BlockDataAdaptor adaptor=new BlockDataAdaptor();
        adaptor.insert(block);




        Result result=new Result();
        result.setError(false);
        return  result;
    }

    public static Result unblock(Block block) throws SQLException {
        BlockDataAdaptor adaptor=new BlockDataAdaptor();
        adaptor.delete(block.getId());

        Result result=new Result();
        result.setError(false);
        return result;
    }

    @Override
    public Result<Block> edit(String content, boolean... saveToDatabase) throws Exception {
        return null;
    }

    @Override
    public Result<Block> delete() throws Exception {
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
        PrintUtility.printBlock(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        Block block = (Block) o;
        return id == block.id ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, blocker, blocked, blockedAt);
    }
}
