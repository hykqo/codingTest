/*1. 두 배열 합치기
설명

오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력하는 프로그램을 작성하세요.

입력
첫 번째 줄에 첫 번째 배열의 크기 N(1<=N<=100)이 주어집니다.
두 번째 줄에 N개의 배열 원소가 오름차순으로 주어집니다.
세 번째 줄에 두 번째 배열의 크기 M(1<=M<=100)이 주어집니다.
네 번째 줄에 M개의 배열 원소가 오름차순으로 주어집니다.
각 리스트의 원소는 int형 변수의 크기를 넘지 않습니다.

출력
오름차순으로 정렬된 배열을 출력합니다.


예시 입력 1
3
1 3 5
5
2 3 6 7 9

예시 출력 1
1 2 3 3 5 6 7 9*/

package com.company.algorithm.twoPointers.twoPointersAdd;

import java.util.Scanner;

public class Main {
    public void result(int n, int m, int[] arr1, int[] arr2){
        int[] res = new int[n+m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){

            }
        }
    }

    public static void main(String[] args) {
        Main res = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        for(int i=0; i<n; i++) arr1[i] = sc.nextInt();
        int m = sc.nextInt();
        int[] arr2 = new int[n];
        for(int i=0; i<m; i++) arr2[i] = sc.nextInt();
        res.result(n,m,arr1,arr2);
    }


}
