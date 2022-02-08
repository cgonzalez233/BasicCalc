package com.revature;

import java.util.Scanner;

public class Questions {
    Scanner scan = new Scanner(System.in);
    mathSwitch math = new mathSwitch();

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public void numbers(){
        System.out.println();
        System.out.println(ANSI_BLUE + "Basic Java Calculator" + ANSI_RESET);
        System.out.println("---------------------");
        System.out.println("Please input your first number");
        double x = scan.nextDouble();

        System.out.println("Please input your second number");
        double y = scan.nextDouble();

        whatToDo(x, y);


    };

    public void whatToDo(double x, double y){
        System.out.println(ANSI_BLUE + "Would you like to do? " + ANSI_RESET);
        System.out.println("------------------");
        System.out.println(ANSI_PURPLE + "1. Add" +ANSI_RESET);
        System.out.println(ANSI_RED + "2. Subtract" + ANSI_RESET);
        System.out.println(ANSI_GREEN + "3. Multiply" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "4. Divide" + ANSI_RESET);



        math.mathAns(x, y);



    };

    public void again(){
        System.out.println();
        System.out.println();
        System.out.println(ANSI_BLUE + "Would you like to do another calculation?" + ANSI_RESET);
        System.out.println("-----------------------------------------");
        System.out.println(ANSI_GREEN + "1. Yes" + ANSI_RESET);
        System.out.println(ANSI_RED + "2. No" + ANSI_RESET);

        int ans = scan.nextInt();

        switch(ans){
            case 1:
                numbers();
                break;
            case 2:
                System.out.println(ANSI_BLUE +"Thank You! Have a good day!" + ANSI_RESET);
                break;
            default:
                again();
                break;

        }
    }
}
