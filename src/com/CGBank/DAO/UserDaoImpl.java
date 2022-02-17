package com.CGBank.DAO;

import com.CGBank.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao{

    Connection connection;

    public UserDaoImpl() {
        this.connection = ConnectionFactory.getConnection();
    }



    @Override
    public List<User> findAll() throws SQLException {
        String sql = "select * from users";

        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sql);

        List<User> allUsers = new ArrayList<User>();

        while(result.next()){
            int id = result.getInt("user_id");
            String username = result.getString("username");
            String password = result.getString("pass");
            boolean isAdmin = result.getBoolean("is_admin");
            String firstName = result.getString("first_name");
            String lastName = result.getString("last_name");

            allUsers.add(new User(id, username, password, isAdmin, firstName, lastName));
        }

        return allUsers;
    }

    @Override
    public User findByUsername(String username) throws SQLException {
        String sql = "select * from users where username = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, username);

        ResultSet result = preparedStatement.executeQuery();
        User user = new User();

        while(result.next()){
            user.setId(result.getInt("user_id"));
            user.setUsername(result.getString("username"));
            user.setPassword(result.getString("pass"));
            user.setAdmin(result.getBoolean("is_admin"));
            user.setFirstName(result.getString("first_name"));
            user.setLastName(result.getString("last_name"));
        }

        return user;
    }

    @Override
    public void addUser(User user) throws SQLException {
        String sql = "insert into users(username, pass, first_name, last_name) values (?,?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setString(3, user.getFirstName());
        preparedStatement.setString(4, user.getLastName());

        int count = preparedStatement.executeUpdate();
        if(count > 0){
            System.out.println("User Saved!");
        }else{
            System.out.println("Oops! Something went wrong");
        }

    }

    @Override
    public void updateUser(String username, String pass) throws SQLException {
        String sql = "update users set username = ?, password = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, pass);

        int count = preparedStatement.executeUpdate();
        if(count > 0){
            System.out.println("User Updated!");
        }else{
            System.out.println("Oops! Something went wrong");
        }

    }

    @Override
    public void deleteUser(int userId) throws SQLException {
        String sql = "delete from users where id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, userId);

        int count = preparedStatement.executeUpdate();
        if(count > 0){
            System.out.println("User Deleted!");
        }else{
            System.out.println("Oops! Something went wrong");
        }

    }

    @Override
    public User findUserById(int userId) throws SQLException {
        String sql = "select * from users where id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, userId);

        ResultSet result = preparedStatement.executeQuery();

        User user = new User();

        while (result.next()){
            user.setId(result.getInt("user_id"));
            user.setUsername(result.getString("username"));
            user.setPassword(result.getString("pass"));
            user.setAdmin(result.getBoolean("is_admin"));
            user.setFirstName(result.getString("first_name"));
            user.setLastName(result.getString("last_name"));

        }

        return user;
    }

    @Override
    public void hireEmp(int userId) throws SQLException {
        String sql = "update users set is_admin = 1 where user_id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, userId);

        int count = preparedStatement.executeUpdate();
        if(count > 0){
            System.out.println("You're Hired!");
        }else{
            System.out.println("Oops! Something went wrong");
        }

    }


}