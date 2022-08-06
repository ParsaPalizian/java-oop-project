package com.company.model;

import com.company.CustomArrayList;
import com.company.Result;
import com.company.dataadapter.ProfilePictureDataAdapter;
import com.company.global.Globals;
import com.company.interfaces.Editable;
import com.company.interfaces.Printable;
import com.company.utility.PrintUtility;

import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDateTime;

public class ProfilePicture  implements Printable, Editable<ProfilePicture> {

    private int id;
    private String address;
    private LocalDateTime sentAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }

    public void setSentAt(LocalDateTime sentAt) {
        this.sentAt = sentAt;
    }

    public static CustomArrayList<ProfilePicture> getProfilePictures(Account account) throws SQLException, ParseException {
        ProfilePictureDataAdapter adapter = new ProfilePictureDataAdapter();
        return adapter.find(new String[][]{{"account_id", account.getId() + ""}});


    }


    public static Result<ProfilePicture> deleteProfilePicture(ProfilePicture mustBeDelete) throws SQLException {
        ProfilePictureDataAdapter profilePictureDataAdapter = new ProfilePictureDataAdapter();
        profilePictureDataAdapter.delete(mustBeDelete.getId());

        Globals.currentAccount.getProfilePictures().remove(mustBeDelete);

        Result<ProfilePicture> result = new Result<>();
        result.setError(false);
        result.setData(mustBeDelete);
        return result;
    }

    public static Result<ProfilePicture> AddProfilePicture(ProfilePicture profilePicture, Account account) throws SQLException {
        ProfilePictureDataAdapter profilePictureDataAdapter = new ProfilePictureDataAdapter();
        profilePicture =  profilePictureDataAdapter.insert(profilePicture, account);

        Result<ProfilePicture> result = new Result<>();
        result.setError(false);
        result.setData(profilePicture);
        return result;
    }


    @Override
    public Result<ProfilePicture> edit(String content, boolean... saveToDatabase) throws Exception {
        return null;
    }

    @Override
    public Result<ProfilePicture> delete() throws Exception {
        return null;
    }

    @Override
    public void printEmptyMessage() {
        PrintUtility.printlnFail("No Picture Found");
        PrintUtility.printlnCommands("(B)ack");
    }

    @Override
    public void printAtFirstPositionMessage() {
        PrintUtility.printlnFail("You Are On First Picture");
    }

    @Override
    public void printAtLastPositionMessage() {
        PrintUtility.printlnFail("You Reached To Last Picture");
    }

    @Override
    public void printContent() {
        PrintUtility.printProfilePicture(this);
    }
}
