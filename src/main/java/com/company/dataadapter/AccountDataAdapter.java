package com.company.dataadapter;

import com.company.CustomArrayList;
import com.company.db.*;
import com.company.model.Account;
import com.company.model.Follow;
import com.company.utility.DateUtility;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedHashSet;

public class AccountDataAdapter {
    public static final String TABLE_NAME = "accounts";
    public static final String[] FIELDS = {
            "id",
            "type",
            "first_name",
            "last_name",
            "username",
            "phone_number",
            "email	",
            "location",
            "registered_at",
            "birthday",
            "password",
            "forgot_password_question",
            "forgot_password_answer",
            "bio",
            "profile_picture	",
            "last_login"
    };
    DatabaseHelper dbHelper;

    public AccountDataAdapter() throws SQLException {
        this.dbHelper = new DatabaseHelper();
//        dbHelper.connect();
    }

    public CustomArrayList<Account> recommend(int id, int wanted, CustomArrayList<Follow> followings) throws SQLException, ParseException {

        if (!dbHelper.isConnected()) {
            dbHelper = new DatabaseHelper();
            dbHelper.connect();
        }

        String sql = String.format("SELECT followed_id  , COUNT(followed_id) as cnt , accounts.*  from followings INNER JOIN accounts ON accounts.id = followings.followed_id  WHERE follower_id in (SELECT followed_id from followings WHERE followings.follower_id = %d) and followed_id <> %d  GROUP BY  followed_id ORDER BY cnt DESC", id, id);
        ResultSet rs = dbHelper.select(sql);
        LinkedHashSet<Account> accounts = new LinkedHashSet<>();

        wanted = wanted % 2 == 0 ? wanted : wanted + 1;

        while (rs.next()) {
            Account account = new Account();
            account.setId(rs.getInt("id"));
            account.setFirstName(rs.getString("first_name"));
            account.setLastName(rs.getString("last_name"));
            account.setUserName(rs.getString("username"));
            account.setPassword(rs.getString("password"));
            account.setPhoneNumber(rs.getString("phone_number"));
            account.setBio(rs.getString("bio"));
            account.setBusiness(rs.getBoolean("business"));
            account.setPrivate(rs.getBoolean("private"));
            account.setEmail(rs.getString("email"));
            account.setBirthday(DateUtility.parseStringToLocalDate(rs.getString("birthday")));
            account.setLastLogin(DateUtility.parseStringToLocalDateTime(rs.getString("last_login")));
            account.setRegisteredAt(DateUtility.parseStringToLocalDateTime(rs.getString("registered_at")));

            boolean found = false;
            for (Follow follow : followings) {
                if (account.getId() == follow.getAccount().getId()) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                accounts.add(account);
            }

            if (accounts.size() == wanted / 2) {
                break;
            }

        }

        sql = String.format("SELECT follower_id , COUNT(follower_id) as cnt , accounts.* from followings INNER JOIN accounts ON accounts.id = followings.follower_id WHERE followed_id in (SELECT followed_id from followings WHERE followings.follower_id = %d) and follower_id <> %d  GROUP BY  follower_id ORDER BY cnt DESC", id, id);
        rs = dbHelper.select(sql);
        while (rs.next()) {
            Account account = new Account();
            account.setId(rs.getInt("id"));
            account.setFirstName(rs.getString("first_name"));
            account.setLastName(rs.getString("last_name"));
            account.setUserName(rs.getString("username"));
            account.setPassword(rs.getString("password"));
            account.setPhoneNumber(rs.getString("phone_number"));
            account.setBio(rs.getString("bio"));
            account.setEmail(rs.getString("email"));
            account.setBusiness(rs.getBoolean("business"));
            account.setPrivate(rs.getBoolean("private"));
            account.setBirthday(DateUtility.parseStringToLocalDate(rs.getString("birthday")));
            account.setLastLogin(DateUtility.parseStringToLocalDateTime(rs.getString("last_login")));
            account.setRegisteredAt(DateUtility.parseStringToLocalDateTime(rs.getString("registered_at")));


            boolean found = false;
            for (Follow follow : followings) {
                if (account.getId() == follow.getAccount().getId()) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                accounts.add(account);
            }


            if (accounts.size() == wanted) {
                break;
            }

        }

        dbHelper.disconnect();
        dbHelper.setConnection(null);
        CustomArrayList<Account> accounts1 = new CustomArrayList<>(Account::new);
        accounts1.addAll(accounts);
        return accounts1;

    }

    public boolean saveSearch(int searcherId, int searchedId) throws SQLException {
        if (!dbHelper.isConnected()) {
            dbHelper = new DatabaseHelper();
            dbHelper.connect();
        }

        String sql = String.format("DELETE FROM searched_accounts WHERE searcher_id= %d AND searched_id= %d", searcherId, searchedId);
        dbHelper.execute(sql);

        sql = String.format("insert into searched_accounts (searcher_id,searched_id) VALUES (%d,%d)", searcherId, searchedId);
        dbHelper.insert(sql);
        dbHelper.disconnect();
        dbHelper.setConnection(null);
        return true;
    }

    public CustomArrayList<Account> loadHistory(int searcherId) throws SQLException, ParseException {
        if (!dbHelper.isConnected()) {
            dbHelper = new DatabaseHelper();
            dbHelper.connect();
        }
        String sql = String.format("SELECT accounts.* FROM accounts INNER JOIN searched_accounts ON searched_accounts.searched_id=accounts.id WHERE searched_accounts.searcher_id=%d", searcherId);
        ResultSet rs = dbHelper.select(sql);
        CustomArrayList<Account> accounts = new CustomArrayList<Account>(Account::new);
        while (rs.next()) {
            Account account = new Account();
            account.setId(rs.getInt("id"));
            account.setFirstName(rs.getString("first_name"));
            account.setLastName(rs.getString("last_name"));
            account.setUserName(rs.getString("username"));
            account.setPassword(rs.getString("password"));
            account.setPhoneNumber(rs.getString("phone_number"));
            account.setBusiness(rs.getBoolean("business"));
            account.setPrivate(rs.getBoolean("private"));
            account.setBio(rs.getString("bio"));
            account.setEmail(rs.getString("email"));
            account.setAvatar(rs.getString("avatar"));
            account.setBirthday(DateUtility.parseStringToLocalDate(rs.getString("birthday")));
            account.setLastLogin(DateUtility.parseStringToLocalDateTime(rs.getString("last_login")));
            account.setRegisteredAt(DateUtility.parseStringToLocalDateTime(rs.getString("registered_at")));
            accounts.add(account);
        }
        dbHelper.disconnect();
        dbHelper.setConnection(null);
        return accounts;
    }

    public Account insert(Account account) throws SQLException {


        if (!dbHelper.isConnected()) {
            dbHelper = new DatabaseHelper();
            dbHelper.connect();
        }

        String sql = String.format(
                "INSERT INTO %s (first_name,last_name,username,`password`,email,forgot_password_question,forgot_password_answer , avatar) VALUES  ('%s','%s','%s','%s','%s','%s','%s' , '%s')",
                TABLE_NAME,
                account.getFirstName(),
                account.getLastName(),
                account.getUserName(),
                account.getPassword(),
                account.getEmail(),
                account.getForgetPasswordQuestion(),
                account.getForgetPasswordAnswer(),
                account.getAvatar()

        );

        int id = dbHelper.insert(sql);
        account.setId(id);
        dbHelper.disconnect();
        dbHelper.setConnection(null);
        return account;
    }

    public void delete(Account account) {

    }

    public CustomArrayList<Account> search(String username) throws SQLException, ParseException {
        if (!dbHelper.isConnected()) {
            dbHelper = new DatabaseHelper();
            dbHelper.connect();
        }

        String sql = String.format("select * from %s where username Like '%s'", TABLE_NAME, "%" + username + "%");
        ResultSet rs = dbHelper.select(sql);
        CustomArrayList<Account> accounts = new CustomArrayList<Account>(Account::new);
        while (rs.next()) {
            Account account = new Account();
            account.setId(rs.getInt("id"));
            account.setFirstName(rs.getString("first_name"));
            account.setLastName(rs.getString("last_name"));
            account.setUserName(rs.getString("username"));
            account.setPassword(rs.getString("password"));
            account.setBusiness(rs.getBoolean("business"));
            account.setPrivate(rs.getBoolean("private"));
            account.setPhoneNumber(rs.getString("phone_number"));
            account.setBio(rs.getString("bio"));
            account.setEmail(rs.getString("email"));
            account.setAvatar(rs.getString("avatar"));
            account.setBirthday(DateUtility.parseStringToLocalDate(rs.getString("birthday")));
            account.setLastLogin(DateUtility.parseStringToLocalDateTime(rs.getString("last_login")));
            account.setRegisteredAt(DateUtility.parseStringToLocalDateTime(rs.getString("registered_at")));
            accounts.add(account);
        }
        dbHelper.disconnect();
        dbHelper.setConnection(null);
        return accounts;
    }

    public Account update(Account account) throws SQLException {
        if (!dbHelper.isConnected()) {
            dbHelper = new DatabaseHelper();
            dbHelper.connect();
        }


        String sql = "UPDATE " + TABLE_NAME + " SET ";


        if (account.getFirstName() != null) {
            sql += String.format("first_name = '%s' ,", account.getFirstName());
        }
        if (account.getLastName() != null) {
            sql += String.format("last_name  = '%s' ,", account.getLastName());
        }
        if (account.getUserName() != null) {
            sql += String.format("username = '%s' ,", account.getUserName());
        }
        if (account.getPassword() != null) {
            sql += String.format("`password`  = '%s' ,", account.getPassword());
        }
        if (account.getEmail() != null) {
            sql += String.format("email  = '%s'  ,", account.getEmail());
        }
        if (account.getPhoneNumber() != null) {
            sql += String.format("phone_number= '%s' ,", account.getPhoneNumber());
        }
        if (account.getBirthday() != null) {
            sql += String.format("birthday  = '%s' ,", account.getBirthday());
        }
        if (account.getBio() != null) {
            sql += String.format("bio  = '%s'  ,", account.getBio());
        }
        sql += String.format("business  = '%d'  ,", account.isBusiness() ? 1 : 0);
        sql += String.format("private  = '%d'  ,", account.isPrivate() ? 1 : 0);

        sql = sql.trim().substring(0, sql.length() - 1);
        sql += String.format(" WHERE id = %d", account.getId());
        dbHelper.execute(sql);
        dbHelper.disconnect();
        dbHelper.setConnection(null);
        return account;
    }

    public ArrayList<Account> findAll() throws SQLException {
        if (!dbHelper.isConnected()) {
            dbHelper = new DatabaseHelper();
            dbHelper.connect();
        }

        String sql = String.format("SELECT * FROM %s", TABLE_NAME);

        ResultSet rs = dbHelper.select(sql);
        ArrayList<Account> accounts = new ArrayList<>();
        while (rs.next()) {
            Account account = new Account();
            account.setFirstName(rs.getString("first_name"));
            account.setLastName(rs.getString("last_name"));
            account.setUserName(rs.getString("username"));
            account.setPassword(rs.getString("password"));
            account.setBusiness(rs.getBoolean("business"));
            account.setPrivate(rs.getBoolean("private"));
            account.setEmail(rs.getString("email"));
            account.setAvatar(rs.getString("avatar"));
            accounts.add(account);
        }

        dbHelper.disconnect();
        dbHelper.setConnection(null);
        return accounts;


    }

    public Account findOne(int id) throws SQLException {
        if (!dbHelper.isConnected()) {
            dbHelper = new DatabaseHelper();
            dbHelper.connect();
        }

        String sql = "SELECT * FROM accounts WHERE   id = " + id;
        ResultSet rs = dbHelper.select(sql);
        Account account = new Account();
        while (rs.next()) {
            account.setId(id);
            account.setFirstName(rs.getString("first_name"));
            account.setLastName(rs.getString("last_name"));
            account.setUserName(rs.getString("username"));
            account.setPassword(rs.getString("password"));
            account.setBusiness(rs.getBoolean("business"));
            account.setPrivate(rs.getBoolean("private"));
            account.setEmail(rs.getString("email"));
            account.setAvatar(rs.getString("avatar"));
            return account;
        }

        dbHelper.disconnect();
        dbHelper.setConnection(null);
        return null;

    }

    public Account findOneByUsername(String username) throws SQLException {
        if (!dbHelper.isConnected()) {
            dbHelper = new DatabaseHelper();
            dbHelper.connect();
        }

        String sql = "SELECT * FROM accounts WHERE username = " + username;
        ResultSet rs = dbHelper.select(sql);
        Account account = new Account();
        while (rs.next()) {
            account.setId(rs.getInt("id"));
            account.setFirstName(rs.getString("first_name"));
            account.setLastName(rs.getString("last_name"));
            account.setUserName(username);
            account.setPassword(rs.getString("password"));
            account.setBusiness(rs.getBoolean("business"));
            account.setPrivate(rs.getBoolean("private"));
            account.setEmail(rs.getString("email"));
            account.setAvatar(rs.getString("avatar"));
            return account;
        }

        dbHelper.disconnect();
        dbHelper.setConnection(null);
        return null;

    }


    public ArrayList<Account> find(String[] keys, String[] values) throws SQLException, ParseException {

        if (!dbHelper.isConnected()) {
            dbHelper = new DatabaseHelper();
            dbHelper.connect();
        }

        String sql = "SELECT * FROM " + TABLE_NAME;
        ArrayList<String> keyValues = new ArrayList<>();
        if (keys != null && values != null && keys.length > 0 && values.length > 0) {
            for (int i = 0; i < keys.length; i++) {
                keyValues.add("`" + keys[i] + "` = '" + values[i] + "' ");
            }
            String[] arrKeyValues = keyValues.toArray(new String[0]);
            String whereClause = String.join(" AND ", arrKeyValues);
            sql += " WHERE " + whereClause;
        }

        ResultSet rs = dbHelper.select(sql);
        ArrayList<Account> accounts = new ArrayList<>();
        while (rs.next()) {
            Account account = new Account();
            account.setId(rs.getInt("id"));
            account.setFirstName(rs.getString("first_name"));
            account.setLastName(rs.getString("last_name"));
            account.setUserName(rs.getString("username"));
            account.setPassword(rs.getString("password"));
            account.setPhoneNumber(rs.getString("phone_number"));
            account.setAvatar(rs.getString("avatar"));
            account.setBusiness(rs.getBoolean("business"));
            account.setPrivate(rs.getBoolean("private"));
            account.setBio(rs.getString("bio"));
            account.setEmail(rs.getString("email"));
            account.setBirthday(DateUtility.parseStringToLocalDate(rs.getString("birthday")));
            account.setRegisteredAt(DateUtility.parseStringToLocalDateTime(rs.getString("registered_at")));
            accounts.add(account);
        }

        dbHelper.disconnect();
        dbHelper.setConnection(null);

        return accounts;

    }


    public int count(String[] keys, String[] values) throws SQLException {

        if (!dbHelper.isConnected()) {
            dbHelper = new DatabaseHelper();
            dbHelper.connect();
        }

        String sql = "SELECT * FROM " + TABLE_NAME;
        ArrayList<String> keyValues = new ArrayList<>();
        if (keys != null && values != null && keys.length > 0 && values.length > 0) {
            for (int i = 0; i < keys.length; i++) {
                keyValues.add("`" + keys[i] + "` = '" + values[i] + "' ");
            }
            String[] arrKeyValues = keyValues.toArray(new String[0]);
            String whereClause = String.join(" AND ", arrKeyValues);
            sql += " WHERE " + whereClause;
        }

        ResultSet rs = dbHelper.select(sql);


        int cnt = 0;
        while (rs.next()) {
            cnt++;
        }

        dbHelper.disconnect();
        dbHelper.setConnection(null);
        return cnt;

    }

    public Account findBaseOnUserName(String userName) throws SQLException {

        if (!dbHelper.isConnected()) {
            dbHelper = new DatabaseHelper();
            dbHelper.connect();
        }

        String sql = "SELECT * FROM accounts WHERE   username = '" + userName + "'";
        ResultSet rs = dbHelper.select(sql);
        Account account = new Account();
        while (rs.next()) {
            account.setId(rs.getInt("id"));
            account.setFirstName(rs.getString("first_name"));
            account.setLastName(rs.getString("last_name"));
            account.setUserName(userName);
            account.setPassword(rs.getString("password"));
            account.setBusiness(rs.getBoolean("business"));
            account.setPrivate(rs.getBoolean("private"));
            account.setEmail(rs.getString("email"));
            account.setAvatar(rs.getString("avatar"));
            account.setForgetPasswordQuestion(rs.getString("forgot_password_question"));
            account.setForgetPasswordAnswer(rs.getString("forgot_password_answer"));
            return account;
        }

        dbHelper.disconnect();
        dbHelper.setConnection(null);
        return null;
    }

    public void clearSearchedHistory(int id) throws SQLException {
        if (!dbHelper.isConnected()) {
            dbHelper = new DatabaseHelper();
            dbHelper.connect();
        }
        String sql = String.format("DELETE from searched_accounts WHERE searcher_id=%d", id);
        dbHelper.execute(sql);
        dbHelper.disconnect();
        dbHelper.setConnection(null);
    }

    public void deleteFromSearchHistory(int searcherId, int searchedId) throws SQLException {
        if (!dbHelper.isConnected()) {
            dbHelper = new DatabaseHelper();
            dbHelper.connect();
        }
        String sql = String.format("DELETE from searched_accounts WHERE searcher_id=%d AND searched_id=%d", searcherId, searchedId);
        dbHelper.execute(sql);
        dbHelper.disconnect();
        dbHelper.setConnection(null);
    }
}
