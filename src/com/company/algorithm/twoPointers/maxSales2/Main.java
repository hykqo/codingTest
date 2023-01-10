/*
* 3. 최대 매출
설명
현수의 아빠는 제과점을 운영합니다. 현수 아빠는 현수에게 N일 동안의 매출기록을 주고 연속된 K일 동안의 최대 매출액이 얼마인지 구하라고 했습니다.
만약 N=10이고 10일 간의 매출기록이 아래와 같습니다. 이때 K=3이면
12 15 11 20 25 10 20 19 13 15
연속된 3일간의 최대 매출액은 11+20+25=56만원입니다.
여러분이 현수를 도와주세요.

입력
첫 줄에 N(5<=N<=100,000)과 K(2<=K<=N)가 주어집니다.
두 번째 줄에 N개의 숫자열이 주어집니다. 각 숫자는 500이하의 음이 아닌 정수입니다.

출력
첫 줄에 최대 매출액을 출력합니다.

예시 입력 1
10 3
12 15 11 20 25 10 20 19 13 15

예시 출력 1
56
*투포인트로 풀어보자.
* k만큼의 창문들 만들어서 n의 끝까지 밀어서 답을 구해보자.
* 창문들 안의 값은 sum이라는 변수안에 보관하자.
* 창문을 한칸 밀기전에 res의 값과 sum의 값을 비교해서 큰 값을 res에 보관하자.
* 반복문이 완료되면 res를 호출하자.
*
*
* 창문을 한칸씩 미는 방법.(슬라이딩 윈도우 방법)
* 1. k창문 안의 합에 다음값을 더해주고(+arr[i]),
* 2. k창문 안의 합에 이전값을 빼주면 된다(-arr[i-k]
* */
package com.company.algorithm.twoPointers.maxSales2;
import java.util.Scanner;
public class Main {
    private int result(int n, int k, int[] arr) {
        int res, sum=0;
        //창문만들기
        for(int i=0; i<k; i++) sum+=arr[i];
        res = sum;
        for(int i=k; i<n; i++) {
            sum += (arr[i] - arr[i-k]);
            res = Math.max(res, sum);
        }
        return res;
    }
    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc =  new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) arr[i] =  sc.nextInt();
        System.out.println(m.result(n,k,arr));
    }
}
