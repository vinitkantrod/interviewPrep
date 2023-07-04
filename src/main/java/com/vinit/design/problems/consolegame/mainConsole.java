package com.vinit.design.problems.consolegame;

import java.util.Scanner;

public class mainConsole {

    public static void main(String[] args) {
        System.out.println("===========================");
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want to start the console? (y/n)");
        String option = sc.nextLine();
        if (option.equals("y") || option.equals("Y")) {
            // Game Starts Here
            System.out.println("########### CONSOLE ############");
            System.out.println("initialising Board");
            Board board = new Board();
        } else {
            System.out.println("Thank you for your input! \n Closing Console");
            System.out.println("===========================");
            return;
        }

    }
}
