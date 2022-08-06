package com.company.model;

import com.company.CustomArrayList;
import com.company.Result;
import com.company.dataadapter.RequestDataAdapter;
import com.company.interfaces.Editable;
import com.company.interfaces.Printable;
import com.company.utility.PrintUtility;

import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDateTime;

public class Request implements Printable, Editable<Request> {
    private int id;
    private Account from;
    private Account to;
    private LocalDateTime sentAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Account getFrom() {
        return from;
    }

    public void setFrom(Account from) {
        this.from = from;
    }

    public Account getTo() {
        return to;
    }

    public void setTo(Account to) {
        this.to = to;
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }

    public void setSentAt(LocalDateTime sentAt) {
        this.sentAt = sentAt;
    }



    public Result<Request> confirm(Request request) throws SQLException {
        RequestDataAdapter adapter = new RequestDataAdapter();
        request = adapter.update(request);
        Result<Request> result = new Result<>();
        result.setData(request);
        return result;
    }

    public Result<Request> reject() throws Exception {
        RequestDataAdapter adapter = new RequestDataAdapter();
         adapter.delete(this.getId());
//        Globals.currentAccount.getRequests().current().delete();
        Result<Request> result = new Result<>();
        result.setData(this);
        return result;
    }

    public  static Result<Request> request(Account from,Account to) throws SQLException {
        RequestDataAdapter adapter = new RequestDataAdapter();
        Request request1=new Request();
        request1.setFrom(from);
        request1.setTo(to);


        request1 = adapter.insert(request1);
        Result<Request> result = new Result<>();
        result.setData(request1);
        return result;
    }

    public static Result<Request> cancel(Request request) throws SQLException {

        RequestDataAdapter adapter = new RequestDataAdapter();
        adapter.delete(request.getId());
        Result<Request> result = new Result<>();
        result.setData(request);
        return result;

    }

    public static Result<CustomArrayList<Request>> getRequests(Account account) throws SQLException, ParseException {
        RequestDataAdapter adapter =new RequestDataAdapter();
        CustomArrayList<Request> requests;
        requests=adapter.find(account.getId());

        Result<CustomArrayList<Request>> result =new Result<>();
        result.setError(false);
        result.setData(requests);
        return result;
    }

    @Override
    public Result<Request> edit(String content, boolean... saveToDatabase) throws Exception {
        return null;
    }

    @Override
    public Result<Request> delete() throws Exception {
        RequestDataAdapter adapter = new RequestDataAdapter();
        adapter.delete(this.getId());
        Result<Request> result = new Result<>();
        result.setData(this);
        return result;

    }

    @Override
    public void printEmptyMessage() {
        PrintUtility.printlnFail("No Request Found");
        PrintUtility.printlnCommands("(B)ack");
    }

    @Override
    public void printAtFirstPositionMessage() {
        PrintUtility.printlnFail("You Are On First Request");
    }

    @Override
    public void printAtLastPositionMessage() {
        PrintUtility.printlnFail("You Reached To Last Post");
    }

    @Override
    public void printContent() {
        PrintUtility.printRequest(this);
    }
}
