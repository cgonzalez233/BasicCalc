package com.CGBank.DAO;

import java.sql.SQLException;
import java.util.List;

public interface AccountDao {

    public List<Account> findAllAcc() throws SQLException;
    public List<Account> findAccByOwner (String username) throws SQLException;
    public void addAcc(Account a) throws SQLException; //return the generated primary key of the new Account object that has been inserted
    public void depositAcc(int accId, double balance) throws SQLException;
    public void withdrawAcc(int accId, double balance) throws SQLException;
    public void deleteAcc(int accId) throws SQLException;
    public List<Account> findByPending() throws SQLException;
    public Account findByAccId(int accId) throws SQLException;
    public void activateAcc(int accId) throws SQLException;

}
