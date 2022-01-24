package com.example.restreact.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnection {

    public static Connection getMySQLConnection() {
        // Note: Change the connection parameters accordingly.
        String hostName = "localhost";
        String dbName = "rememberme";
        String userName = "root";
        String password = "";
        try {
            return getMySQLConnection(hostName, dbName, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Connection getMySQLConnection(String hostName, String dbName,
                                                 String userName, String password) throws SQLException,
            ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;

        Connection conn = DriverManager.getConnection(connectionURL, userName,
                password);
        return conn;
    }
}
