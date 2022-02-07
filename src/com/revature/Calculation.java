package com.revature;

import java.util.Scanner;

public class Calculation {
    Scanner scan = new Scanner(System.in);
    Questions questions = new Questions();
    int x;
    int y;

    public Calculation(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Calculation(){

    }


    public void add(){
        System.out.println();
        System.out.println(x + " + " + y + " = " + (x + y));
        questions.again();
    }
    public void sub(){
        System.out.println();
        System.out.println(x + " - " + y + " = " + (x - y));
        questions.again();
    }
    public void mul(){
        System.out.println();
        System.out.println(x + " x " + y + " = " + (x * y));
        questions.again();
    }
    public void div(){
        System.out.println();
        System.out.println(x + " / " + y + " = " + (x / y));
        questions.again();
    }



}
