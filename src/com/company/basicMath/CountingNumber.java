package com.company.basicMath;

import java.util.Scanner;

public class CountingNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] sList = scanner.nextLine().split(" ");
        int findNumber = scanner.nextInt();

        int[] numbers = new int[n];
        for(int i=0; i<n; i++) {
            numbers[i] = Integer.parseInt(sList[i]);
        }

        int count = 0;
        for(int number : numbers){
            if(number == findNumber){
                count++;
            }
        }
        System.out.println(count);
    }
}
