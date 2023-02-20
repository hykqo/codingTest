/*피보나치 수열
*
* 1) 피보나치 수열을 출력한다. 피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는 수열이다.
* 2) 입력은 피보나치 수열의 총 항의 수 이다. 만약 7이 입력되면 1 1 2 3 5 8 13 을 출력하면 된다.
*
* 입력설명
* 첫 줄에 총 항수 N(3<=N<=45)이 입력된다.
*
* 출력설명
* 첫 줄에 피보나치 수열을 출력합니다.
*
* 입력예제
* 10
*
* 출력예제
* 1 1 2 3 5 8 13 21 34 55*/

package com.company.algorithm.recursive$Tree$DFS$BFS.fibonacciRecurision5;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] fibo;
    private static int DFS(int n){
        //0보다 큰 값이 있으면 이미 한번 구해봤던 값. dfs로 구할 필요가 없음.
        if(fibo[n] > 0) return fibo[n];
        if(n == 1) return fibo[n] = 1;
        else if(n == 2) return fibo[n] = 1;
        else return fibo[n] = DFS(n-2) + DFS(n-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        fibo = new int[n+1];
        DFS(n);
        for(int i=1; i<=n; i++) System.out.print(fibo[i]+" ");

    }
}
