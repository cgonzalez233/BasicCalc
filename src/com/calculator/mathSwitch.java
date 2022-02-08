package com.calculator;

import java.util.Scanner;

public class mathSwitch {
    public void mathAns(double x, double y){
        Scanner scan = new Scanner(System.in);
        Calculation calc = new Calculation(x, y);
        Questions q2 = new Questions();

        int choice = scan.nextInt();

        switch(choice){
            case 1:
                calc.add();
                break;
            case 2:
                calc.sub();
                break;
            case 3:
                calc.mul();
                break;
            case 4:
                calc.div();
                break;
            default:
                System.out.println("That is an invalid input");
                q2.whatToDo(x, y);


        }
    }
}
