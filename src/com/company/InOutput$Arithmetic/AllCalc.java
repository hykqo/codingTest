package com.company.InOutput$Arithmetic;

import java.util.Scanner;

public class AllCalc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        new AllCalc(a, b);
    }

    public AllCalc(int a, int b) {
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
