package com.CGBank.DAO;

import com.CGBank.ConnectionFactory;
import com.CGBank.Main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class UserDaoImpl implements UserDao{

    static Main main = new Main();
    static Scanner scan = new Scanner(System.in);

    static User currentUser = null;

    Connection connection;

    public UserDaoImpl() {
        this.connection = ConnectionFactory.getConnection();
    }


    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findByUsername(String username) {
        return null;
    }

    @Override
    public int insert(User u) {
        return 0;
    }

    @Override
    public boolean update(User u) {
        return false;
    }

    @Override
    public boolean delete(int userId) {
        return false;
    }

    @Override
    public User findById(int userId) {
        return null;
    }
}