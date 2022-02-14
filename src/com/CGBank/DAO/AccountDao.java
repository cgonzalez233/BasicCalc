package com.CGBank.DAO;

import java.util.List;

public interface AccountDao {

    public List<Account> findAll();
    public Account findById(int accId);
    public List<Account> findByOwner (int userId);
    public int insert(Account a); //return the generated primary key of the new Account object that has been inserted
    public boolean update(Account a);
    public boolean delete(int accId);
    public List<Account> findByPending();

}
