package com.company.db;

import java.sql.*;

public class DatabaseHelper {

    private Connection connection = null;
    public static final String DATABASE_ADDRESS = "localhost";
    public static final String DATABASE_PORT = "3306";
    public static final String DATABASE_NAME = "test";
    public static final String DATABASE_USERNAME = "root";
    public static final String DATABASE_PASSWORD = "";

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public boolean isConnected() {
        if (connection != null) {
            return true;
        } else {
            return false;
        }
    }

    public void connect() throws SQLException {
        String url = String.format("jdbc:mysql://%s:%s/%s", DATABASE_ADDRESS, DATABASE_PORT, DATABASE_NAME);
//        System.out.println("Connecting database...");
        connection = DriverManager.getConnection(url, DATABASE_USERNAME, DATABASE_PASSWORD);
//        Statement stmt=connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

    }

    public void execute(String sql) throws SQLException {
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        statement.execute(sql);
    }

    public int insert(String sql) throws SQLException {

        PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        statement.executeUpdate();
        try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                int idd =  generatedKeys.getInt(1);
                return  idd;
            } else {
                throw new SQLException("Creating user failed, no ID obtained.");
            }
        }

    }


    public ResultSet select(String sql) throws SQLException {
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet resultSet = statement.executeQuery(sql);
        return resultSet;

    }

    public void disconnect() throws SQLException {
        connection.close();
        connection = null;
    }


}
