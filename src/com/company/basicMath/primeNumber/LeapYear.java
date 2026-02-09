package com.company.basicMath.primeNumber;

import java.util.Scanner;

public class LeapYear {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long thisYear = scanner.nextLong();
        scanner.close();
        int res;
        if(thisYear % 4 == 0 && thisYear % 100 != 0) res = 1;
        else if(thisYear % 400 == 0) res = 1;
        else res = 0;
        System.out.println(res);
    }
}
