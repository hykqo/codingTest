package com.company.algorithm.twoPointers.continueSubSequence2;

import java.util.Scanner;

/*
* 4. 연속 부분수열
설명
N개의 수로 이루어진 수열이 주어집니다.
이 수열에서 연속부분수열의 합이 특정숫자 M이 되는 경우가 몇 번 있는지 구하는 프로그램을 작성하세요.
만약 N=8, M=6이고 수열이 다음과 같다면
1 2 1 3 1 1 1 2
합이 6이 되는 연속부분수열은 {2, 1, 3}, {1, 3, 1, 1}, {3, 1, 1, 1}로 총 3가지입니다.

입력
첫째 줄에 N(1≤N≤100,000), M(1≤M≤100,000,000)이 주어진다.
수열의 원소값은 1,000을 넘지 않는 자연수이다.

출력
첫째 줄에 경우의 수를 출력한다.

예시 입력 1
8 6
1 2 1 3 1 1 1 2

예시 출력 1
3
*lt와 rt변수를 활용한 투포인터스 알고리즘으로 풀어보자.
* lt는 left, rt는 right를 뜻한다.
* 특정 연속된합을 담기 위해 sum이라는 변수를 만들어주자.
* rt가 마지막 인덱스에 다다르기 전까지 반복한다.
* 반복문 안에서 sum의 값이 6을 넘지 않은 경우 rt의 값을 sum에 더해준다.
* sum이 m과 같은경우 res를 ++해준다
* 이후 sum이 m보다 크거나 같은 경우 실행되는 반복문을 만들자
* 반복문 안에서 lt값을 sum에서 빼보자.
* 이후 lt의 값을 하나씩 증가시킨다.
* sum의 값이 m보다 작을경우 반복문을 빠져나오게끔 하자.

* /
 */
public class Main {
    private int result(int n, int m, int[] arr) {
        int res=0, sum=0, lt=0;
        for(int rt = 0; rt<n; rt++){
            sum+=arr[rt];
            if(sum == m) res++;
            while (sum>=m) {
                sum-=arr[lt++];
                if(sum == m) res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Main res = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = sc.nextInt();
        System.out.println(res.result(n,m,arr));
    }
}
