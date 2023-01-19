/*
* 1. 선택 정렬
설명
N개의 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.
정렬하는 방법은 선택정렬입니다.

입력
첫 번째 줄에 자연수 N(1<=N<=100)이 주어집니다.
두 번째 줄에 N개의 자연수가 공백을 사이에 두고 입력됩니다. 각 자연수는 정수형 범위 안에 있습니다.

출력
오름차순으로 정렬된 수열을 출력합니다.

예시 입력 1
6
13 5 11 7 23 15

* 5 11 7 23 15 13
* 5 7 23 15 13 11
* 5 7 23 15 13 11
* 5 7 15 13 11 23
* 5 7 13 11 23 15
* 5 7 11 23 15 13
* 5 7 11 15 13 23
* 5 7 11 13 23 15
* 5 7 11 13 15 23

예시 출력 1
5 7 11 13 15 23
*/
package com.company.algorithm.sorting$Searching.choiseSort2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = sc.nextInt();

        for (int i=0; i<n-1; i++) {
            //최소값 구하기.
            int idx = i;
            for(int j=i+1; j<n; j++){
                if(arr[j] < arr[idx]) idx = j;
            }
            //구해진 최솟값을 원래 숫자와 스와프.
            int x = arr[i];
            arr[i] = arr[idx];
            arr[idx] = x;

        }
        for(int i : arr) System.out.print(i+" ");
    }
}
