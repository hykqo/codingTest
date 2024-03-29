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

package com.company.algorithm.rc$DFS$BFS.fibonacciRecurision;

import java.util.Scanner;

public class Main {
    public void DFS(int n, int lt, int rt){
        n--;
        if(n==0) return;
        System.out.print(lt+rt+" ");
        DFS(n, rt, lt+rt);
    }
    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        m.DFS(n, 0, 1);

    }
}
