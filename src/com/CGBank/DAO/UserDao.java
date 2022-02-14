package com.CGBank.DAO;

import java.util.List;

public interface UserDao {

    public List<User> findAll();
    public User findByUsername(String username);
    public int insert(User u);
    public boolean update (User u);
    public boolean delete(int userId);
    public User findById(int userId);

}
