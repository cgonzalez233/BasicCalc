package com.revature;

import java.util.Scanner;

public class Questions {
    Scanner scan = new Scanner(System.in);
    mathSwitch math = new mathSwitch();

    public void numbers(){
        System.out.println();
        System.out.println("Basic Java Calculator");
        System.out.println("---------------------");
        System.out.println("Please input your first number");
        int x = scan.nextInt();

        System.out.println("Please input your second number");
        int y = scan.nextInt();

        whatToDo(x, y);


    };

    public void whatToDo(int x, int y){
        System.out.println("Would you like to do ");
        System.out.println("------------------");
        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");



        math.mathAns(x, y);



    };

    public void again(){
        System.out.println();
        System.out.println();
        System.out.println("Would you like to do another calculation?");
        System.out.println("-----------------------------------------");
        System.out.println("1. Yes");
        System.out.println("2. No");

        int ans = scan.nextInt();

        switch(ans){
            case 1:
                numbers();
                break;
            case 2:
                System.out.println("Thank You! Have a good day!");
                break;
            default:
                again();
                break;

        }
    }
}
