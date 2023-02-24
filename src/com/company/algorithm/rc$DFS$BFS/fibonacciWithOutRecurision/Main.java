package com.company.algorithm.rc$DFS$BFS.fibonacciWithOutRecurision;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] fibo = new int[n];
        for(int i = 0; i<n; i++){
            if(i==0 || i==1) fibo[i] = 1;
            else fibo[i] = fibo[i-2] + fibo[i-1];
        }
        for(int i : fibo) System.out.print(i+" ");
    }
}
