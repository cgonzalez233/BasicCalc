package com.CGBank.DAO;

import com.CGBank.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDaoImpl implements AccountDao{

    Connection connection;

    public AccountDaoImpl(){
        this.connection = ConnectionFactory.getConnection();
    }

    @Override
    public List<Account> findAllAcc() throws SQLException {
        String sql = "select * from accounts";

        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sql);

        List<Account> allAcc = new ArrayList<Account>();

        while(result.next()){
            int id = result.getInt("acc_id");
            String owner = result.getString("owner");
            double balance = result.getDouble("balance");
            boolean isActive = result.getBoolean("is_active");
            boolean pending = result.getBoolean("pending");

            allAcc.add(new Account(id, owner, balance, isActive, pending));

        }


        return allAcc;
    }

    @Override
    public List<Account> findAccByOwner(String username) throws SQLException {

        String sql = "select * from accounts where owner = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, username);

        ResultSet result = preparedStatement.executeQuery();

        List<Account> accOwner = new ArrayList<>();

        while(result.next()){
            int id = result.getInt("acc_id");
            String owner = result.getString("owner");
            double balance = result.getDouble("balance");
            boolean isActive = result.getBoolean("is_active");
            boolean pending = result.getBoolean("pending");


            accOwner.add(new Account(id, owner, balance, isActive, pending));

        }

        return accOwner;
    }

    @Override
    public void addAcc(Account acc) throws SQLException {
        String sql = "insert into accounts(acc_id, owner, balance) values(?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, acc.getId());
        preparedStatement.setString(2, acc.getOwner());
        preparedStatement.setDouble(3, acc.getBalance());

        int count = preparedStatement.executeUpdate();
        if(count > 0){
            System.out.println("Account Added!");
        }else{
            System.out.println("Oops! Something went wrong");
        }

    }

    @Override
    public void depositAcc(int accId, double balance) throws SQLException {
        String sql = "update accounts set balance = ? where acc_id = ?";

        Account acc = findByAccId(accId);
        double total = (acc.getBalance() + balance);

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setDouble(1, total);
        preparedStatement.setDouble(2, accId);

        int count = preparedStatement.executeUpdate();
        if(count > 0){
            System.out.println("Account Updated!");
        }else{
            System.out.println("Oops! Something went wrong");
        }

    }

    @Override
    public void withdrawAcc(int accId, double balance) throws SQLException {
        String sql = "update accounts set balance = ? where acc_id = ?";

        Account acc = findByAccId(accId);
        double total = (acc.getBalance() - balance);

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setDouble(1, total);
        preparedStatement.setDouble(2, accId);

        int count = preparedStatement.executeUpdate();
        if(count > 0){
            System.out.println("Account Updated!");
        }else{
            System.out.println("Oops! Something went wrong");
        }

    }

    @Override
    public void deleteAcc(int accId) throws SQLException {
        String sql = "delete from accounts where acc_id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, accId);

        int count = preparedStatement.executeUpdate();
        if(count > 0){
            System.out.println("Account Deleted!");
        }else{
            System.out.println("Oops! Something went wrong");
        }

    }

    @Override
    public List<Account> findByPending() throws SQLException {
        String sql = "select * from accounts where pending = 1";

        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sql);

        List<Account> pendingList = new ArrayList<Account>();

        while(result.next()){
            int id = result.getInt("acc_id");
            String owner = result.getString("owner");
            double balance = result.getDouble("balance");
            boolean isActive = result.getBoolean("is_active");
            boolean pending = result.getBoolean("pending");

            pendingList.add(new Account(id, owner, balance, isActive, pending));

        }

        return pendingList;
    }

    @Override
    public Account findByAccId(int accId) throws SQLException {
        String sql = "select * from accounts where acc_id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, accId);
        ResultSet result = preparedStatement.executeQuery();

        Account acc = new Account();

        while(result.next()){
            acc.setId(result.getInt("acc_id"));
            acc.setOwner(result.getString("owner"));
            acc.setBalance(result.getDouble("balance"));
            acc.setActive(result.getBoolean("is_active"));
            acc.setPending(result.getBoolean("pending"));
        }
        return acc;
    }

    @Override
    public void activateAcc(int accId) throws SQLException {
        String sql = "update accounts set is_active = 1, pending = 0 where acc_id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, accId);

        int count = preparedStatement.executeUpdate();
        if(count > 0){
            System.out.println("Account Activated!");
        }else{
            System.out.println("Oops! something went wrong");
        }

    }


}





