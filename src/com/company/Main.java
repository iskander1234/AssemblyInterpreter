package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MainMethods mainm = new MainMethods();
        System.out.print(">");
        Scanner sc = new Scanner(System.in);
        String cmd = sc.nextLine();
        while (!cmd.isEmpty()){
            System.out.print("> ");
            mainm.execute(cmd);
            cmd = sc.nextLine();
        }
        System.out.println("Result is: " + mainm.getLastValue());
    }
}
