/*2. 버블 정렬
설명
N개이 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.
정렬하는 방법은 버블정렬입니다.

입력
첫 번째 줄에 자연수 N(1<=N<=100)이 주어집니다.
두 번째 줄에 N개의 자연수가 공백을 사이에 두고 입력됩니다. 각 자연수는 정수형 범위 안에 있습니다.

출력
오름차순으로 정렬된 수열을 출력합니다.

예시 입력 1
6
13 5 11 7 23 15

예시 출력 1
5 7 11 13 15 23*/
package com.company.algorithm.sorting$Searching.bubbleSort;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i =0; i<n; i++) arr[i] = sc.nextInt();

        //버블정렬 사용.
        //0의 인덱스부터 인덱스의 끝까지 각 인덱스를 비교하여 제일 높은 자리수를 인덱스의 끝으로 보내는 기법.
        int x = 0;
        while (x < n-1) {
            for (int j = x+1; j < n; j++) {
                if (arr[x] > arr[j]) {
                    int c = arr[x];
                    arr[x] = arr[j];
                    arr[j] = c;
                } else x++;
            }
        }
        for(int i : arr) System.out.print(i+" ");
    }
}
