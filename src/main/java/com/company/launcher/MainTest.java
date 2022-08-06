package com.company.launcher;

import com.company.dataadapter.PostDataAdapter;
import com.company.model.Account;
import com.company.model.Post;

import java.sql.SQLException;

public class MainTest {
    public static void main(String[] args) throws SQLException {
//        String url = "jdbc:mysql://localhost:3306/test";
//        String username = "root";
//        String password = "";
//
//        System.out.println("Connecting database...");
//
//        try (Connection connection = DriverManager.getConnection(url, username, password)) {
//            System.out.println("Database connected!");
//        } catch (SQLException e) {
//            throw new IllegalStateException("Cannot connect the database!", e);
//        }


//        DatabaseHelper dbHelper = new DatabaseHelper() ;
//        dbHelper.connect();
//        dbHelper.execute("INSERT INTO humen (`name` , family) VALUES ( 'ali', 'rezaei')");
//        dbHelper.disconnect();

//        Account account = new Account();
//        account.setFirstName("ali");
//        account.setLastName("rezaei");
//        account.setUserName("ali1234");
//        account.setPassword("123456");
//        account.setEmail("ali@yahoo.com");
//
//        AccountDataAdapter  accountDataAdapter = new AccountDataAdapter();
//        accountDataAdapter.insert(account);


//        DatabaseHelper dbHelper = new DatabaseHelper();
//        dbHelper.connect();
//        dbHelper.execute("INSERT INTO humen (`name` , family) VALUES ( 'ali', 'rezaei')");
//        dbHelper.disconnect();

//        DatabaseHelper dbHelper = new DatabaseHelper();
//        dbHelper.connect();
//        ResultSet rs = dbHelper.select("SELECT * FROM accounts");
//////        rs.last();
//////        System.out.println(rs.getRow());
////        rs.first();
//        while(rs.next()) {
//            String firstName = rs.getString("first_name");
//            String   lastName = rs.getString("last_name");
//            String username = rs.getString("username");
//            String password = rs.getString("password");
//            String email = rs.getString("email");
//            System.out.println(firstName );
//
//        }

//        AccountDataAdapter  accountDataAdapter = new AccountDataAdapter();
//        int c =  accountDataAdapter.count(new String[] {"username" , "password"} , new String[] {"ali" , "1234"});
//        System.out.println(CommandColors.ANSI_RED + c);

        PostDataAdapter adapter = new PostDataAdapter();
        Post post = new Post(0,"aaaa");
        post.setMedia("dddddd");
        post.setAccount(new Account());
        post.getAccount().setId(10);
        post =  adapter.insert(post);




    }
}
