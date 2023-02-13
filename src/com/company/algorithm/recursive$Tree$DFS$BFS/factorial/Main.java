/*
 * 팩토리얼
 *
 * 자연수 N이 입력되면 N!를 구하는 프로그램을 작성하세요.
 * 예를 들어 5! = 5*4*3*2*1=120입니다.
 *
 * 입력설명
 * 첫 번째 줄에 자연수 N(1<=N<=100)이 주어집니다.
 *
 * 출력설명
 * 첫 번째 줄에 N팩토리얼 값을 출력합니다.
 *
 * 입력예제
 * 5
 *
 * 출력예제
 * 120
 * */

package com.company.algorithm.recursive$Tree$DFS$BFS.recursion;

import java.util.Scanner;

public class Main {
    public int DFS(int n){
        if(n == 1) return 1;
        else return n*DFS(n-1);
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(T.DFS(n));
    }
}
