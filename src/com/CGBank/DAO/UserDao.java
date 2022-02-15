package com.CGBank.DAO;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {

    public List<User> findAll() throws SQLException;
    public User findByUsername(String username) throws SQLException;
    public void addUser(User u) throws SQLException;
    public void updateUser (String name, String pass) throws SQLException;
    public void deleteUser (int userId) throws SQLException;
    public User findUserById(int userId) throws SQLException;
    public void hireEmp(int userId) throws SQLException;

}
