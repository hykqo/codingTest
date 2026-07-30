package com.company.basicMath;

/*
2
2 1 2
5 1 1
* */
public interface EuclideanAlgorithm {

    /**
     * 두 수의 최대공약수를 구합니다.
     */
    static int gcd(int a, int b) {
        while (b != 0) {
            int remainder = a % b;
            a = b;
            b = remainder;
        }

        return a;
    }

    /**
     * 두 수의 최소공배수를 구합니다.
     */
    static int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }

    static void main(String[] args) {
        lcm(70,90);
    }
}
