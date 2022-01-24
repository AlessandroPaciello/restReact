package com.example.restreact.crud;

import com.example.restreact.bean.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLCrud {

    public static List<User> getAllUsers(Connection conn) {

        List<User> users = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String SQL = "SELECT * FROM users";

        try {
            ps = conn.prepareStatement(SQL);
            rs = ps.executeQuery();

            while (rs.next()) {
                users.add(new User(rs.getInt("id"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getLong("number"),
                        rs.getString("memo"),
                        rs.getTimestamp("date")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        finally {
            try {
                rs.close();
                ps.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return users;
    }

    public static User getUser(Connection conn, int id) {

        String SQL = "SELECT id, firstname, lastname, number, memo, date FROM users WHERE id = ?";

        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;

        try {
            ps = conn.prepareStatement(SQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                user = new User(
                        rs.getInt("id"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getLong("number"),
                        rs.getString("memo"),
                        rs.getTimestamp("date"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            try {
                rs.close();
                ps.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }

    public static int addUser(Connection conn, User user){

        String SQL = "INSERT INTO users (firstName, lastName, number, memo, date) VALUES (?, ?, ?, ?, ?)";

        PreparedStatement ps = null;
        int elementUpdate = -1;

        try {

            ps = conn.prepareStatement(SQL);
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setLong(3, user.getNumber());
            ps.setString(4, user.getMemo());
            ps.setTimestamp(5, user.getDate());

            elementUpdate = ps.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
            return elementUpdate;
        }

        return elementUpdate;
    }


}
