package com.company;

import java.util.Scanner;

public class allCalc {
    public static void main(String[] args) {
        int a = new Scanner(System.in).nextInt();
        int b = new Scanner(System.in).nextInt();
        new allCalc(a, b);
    }

    public allCalc(int a, int b) {
       plus(a, b);
       minus(a, b);
       mul(a, b);
       devide(a, b);
       remain(a, b);
    }

    void plus(int a, int b){
        System.out.println(a+b);
    }
    void minus(int a, int b){
        System.out.println(a-b);
    }
    void mul(int a, int b){
        System.out.println(a*b);
    }
    void devide(int a, int b){
        System.out.println(a/b);
    }
    void remain(int a, int b){
        System.out.println(a%b);
    }
}
