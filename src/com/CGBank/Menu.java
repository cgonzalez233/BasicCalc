package com.CGBank;

import com.CGBank.DAO.User;
import com.CGBank.DAO.UserDaoImpl;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {

    static Scanner scan = new Scanner(System.in);
    static UserMethods userMethods = new UserMethods();
    static AdminMethods adminMethods = new AdminMethods();

    static User currentUser = null;

    //------------------------------------------------------------------------------------

    public static void mainMenu() throws SQLException {

        System.out.println("Welcome to CGBank! Please make a selection");
        System.out.println("Enter the number in front of your choice");
        System.out.println();
        System.out.println("1. Create an Account");
        System.out.println("2. Manage an existing account");
        System.out.println("3. Employee Login");

        int answer1 = scan.nextInt();

        switch(answer1){
            case 1:
                userMethods.newUser();
                Main.run();
                break;
            case 2:
                if(userMethods.currentUser == null){
                    userMethods.login();
                    userMenu();
                }else{
                    userMenu();
                }
                break;
            case 3:
                if(userMethods.currentUser == null){
                    userMethods.login();
                    empMenu();
                }else{
                    empMenu();
                }
                break;
            default:
                System.out.println("Please enter an accepted number to continue!");
        }

    }

    //------------------------------------------------------------------------------------

    public static void userMenu() throws SQLException {

        if(userMethods.currentUser == null){

            System.out.println("Please login to access accounts!");
            System.out.println();
            System.out.println("1. Login");
            System.out.println("2. Return to Main Menu");

            int answer2 = scan.nextInt();

            switch(answer2){
                case 1:
                    userMethods.login();
                    userMenu();
                    break;
                case 2:
                    Main.run();
                    break;
                default:
                    System.out.println("Please enter an accepted number to continue!");
            }

        }else {
            System.out.println("Welcome back " + userMethods.currentUser.getUsername() + "! Please choose an option");
            System.out.println();
            System.out.println("1. Update Account");
            System.out.println("2. View My Bank Accounts");
            System.out.println("3. Withdraw Funds");
            System.out.println("4. Deposit Funds");
            System.out.println("5. Transfer Funds");
            System.out.println("6. Apply for New Bank Account");
            System.out.println("7. Logout");
            System.out.println("0. Return to Main Menu");

            int answer3 = scan.nextInt();

            switch(answer3){
                case 1:
                    userMethods.updateUser();
                    userMenu();
                    break;
                case 2:
                    userMethods.viewAccs();
                    userMenu();
                    break;
                case 3:
                    userMethods.withdraw();
                    userMenu();
                    break;
                case 4:
                    userMethods.deposit();
                    userMenu();
                    break;
                case 5:
                    userMethods.transfer();
                    userMenu();
                    break;
                case 6:
                    userMethods.apply();
                    userMenu();
                    break;
                case 7:
                    userMethods.currentUser = null;
                    mainMenu();
                    break;
                case 0:
                    Main.run();
                    break;
                default:
                    System.out.println("Please enter an accepted account");

            }
        }

    }

    // ------------------------------------------------------------------------

    public static void empMenu() throws SQLException {
        if(userMethods.currentUser.isAdmin()){

            System.out.println("Welcome back " + userMethods.currentUser.getUsername() + "! Please choose an option");
            System.out.println();
            System.out.println("1. Find All Users");
            System.out.println("2. Find Accounts by Username");
            System.out.println("3. Approve/Deny Account Application");
            System.out.println("4. Cancel A User Account");
            System.out.println("5. Hire New Employee");
            System.out.println("6. Logout");
            System.out.println("0. Return to Main Menu");

            int answer5 = scan.nextInt();

            switch (answer5){
                case 1:
                    adminMethods.findAllUsers();
                    empMenu();
                    break;
                case 2:
                    adminMethods.findByUsername();
                    empMenu();
                    break;
                case 3:
                    adminMethods.appApproval();
                    empMenu();
                    break;
                case 4:
                    adminMethods.deleteAcc();
                    empMenu();
                    break;
                case 5:
                    adminMethods.hire();
                    empMenu();
                    break;
                case 6:
                    currentUser = null;
                    mainMenu();
                    break;
                case 0:
                    Main.run();
                    break;
                default:
                    System.out.println("Please enter an accepted number");
            }

        }else{
            System.out.println("You are not currently logged in as an employee");
            System.out.println("Please login as an employee");
            System.out.println();
            System.out.println("1. Login as Employee");
            System.out.println("2. Return to Main Menu");

            int answer4 = scan.nextInt();

            switch(answer4){
                case 1:
                    userMethods.login();
                    empMenu();
                    break;
                case 2:
                    Main.run();
                    break;
                default:
                    System.out.println("Please enter an accepted number");
            }

        }
    }

    // -------------------------------------------------------------------

}
