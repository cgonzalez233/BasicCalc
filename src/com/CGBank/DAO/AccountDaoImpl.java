package com.CGBank.DAO;

import java.util.List;

public class AccountDaoImpl implements AccountDao{



    @Override
    public List<Account> findAll() {
        return null;
    }

    @Override
    public Account findById(int accId) {
        return null;
    }

    @Override
    public List<Account> findByOwner(int userId) {
        return null;
    }

    @Override
    public int insert(Account a) {
        return 0;
    }

    @Override
    public boolean update(Account a) {
        return false;
    }

    @Override
    public boolean delete(int accId) {
        return false;
    }

    @Override
    public List<Account> findByPending() {
        return null;
    }
}
