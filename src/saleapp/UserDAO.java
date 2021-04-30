/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saleapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UserDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3360/demo?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "quynhtrang2502";
    private static final String INSERT_USERS_SQL = "INSERT INTO user" + " (ID, Username, Password, Email) VALUES " + " (?, ?, ?, ?);";
    private static final String SELECT_USER_BY_ID = "select ID,Username,Password, Email from user where ID =?";
    private static final String SELECT_USER_BY_USERNAME = "select ID,Username,Password, Email from user where Username =?";
    private static final String SELECT_ALL_USERS = "select * from user";
    private static final String DELETE_USERS_SQL = "delete from user where ID = ?;";
    private static final String UPDATE_USERS_SQL = "update user set Username = ?,Password= ?, Email= ? where ID = ?;";
    public UserDAO() {}
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername,jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public void insertUser(UserModel user) throws SQLException {
        System.out.println(INSERT_USERS_SQL);
        try (Connection connection = getConnection(); PreparedStatement
            preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setInt(1, user.getID());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getEmail());
//            preparedStatement.setString(4, user.getFullName());
//            preparedStatement.setString(5, user.getDesc());
//            preparedStatement.setInt(6, user.getAvatar());
//            preparedStatement.setInt(7, user.getPoints());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
    public UserModel selectUser(int ID) {
        UserModel user = null;
        try (Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
            preparedStatement.setInt(1, ID);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String Username = rs.getString("Username");
                String Password = rs.getString("Password");
                String Email = rs.getString("Email");
                user = new UserModel(ID ,Username, Password, Email);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }
    public UserModel selectUser(String username) {
        UserModel user = null;
        try (Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_USERNAME);) {
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int ID = rs.getInt("ID");
                String Username = rs.getString("Username");
                String Password = rs.getString("Password");
                String Email = rs.getString("Email");
                user = new UserModel(ID,Username, Password, Email );
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }
    public ArrayList <UserModel> selectAllUsers() {
        ArrayList <UserModel> users = new ArrayList <> ();
        try (Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int ID = rs.getInt("ID");
                String Username = rs.getString("Username");
                String Password = rs.getString("Password");
                String Email = rs.getString("Email");
                users.add(new UserModel(ID,Username, Password,Email));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;
    }
    public boolean deleteUser(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }
    public boolean updateUser(UserModel user) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
            statement.setInt(1, user.getID());
            statement.setString(2, user.getUsername());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getEmail());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException)e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}