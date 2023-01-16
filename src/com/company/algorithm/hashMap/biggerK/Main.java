/*
* 5. K번째 큰 수
설명
현수는 1부터 100사이의 자연수가 적힌 N장의 카드를 가지고 있습니다. 같은 숫자의 카드가 여러장 있을 수 있습니다.
현수는 이 중 3장을 뽑아 각 카드에 적힌 수를 합한 값을 기록하려고 합니다. 3장을 뽑을 수 있는 모든 경우를 기록합니다.
기록한 값 중 K번째로 큰 수를 출력하는 프로그램을 작성하세요.
만약 큰 수부터 만들어진 수가 25 25 23 23 22 20 19......이고 K값이 3이라면 K번째 큰 값은 22입니다.

입력
첫 줄에 자연수 N(3<=N<=100)과 K(1<=K<=50) 입력되고, 그 다음 줄에 N개의 카드값이 입력된다.

출력
첫 줄에 K번째 수를 출력합니다. K번째 수가 존재하지 않으면 -1를 출력합니다.

예시 입력 1
10 3
13 15 34 23 45 65 33 11 26 42

예시 출력 1
143
*/
package com.company.algorithm.hashMap.biggerK;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = sc.nextInt();
        System.out.println(m.result(n, k, arr));
    }

    private int result(int n, int k, int[] arr) {
        int res = -1;
        //set이라는 자료구조는 중복을 허락하지 않는다. TreeSet은 정렬도 해준다.
        //reverseOrder()는 내림차순으로 정렬을 해주는 기능이다. default셋팅은 오름차순 정렬이다.
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
        for(int a=0; a<arr.length-2; a++)
            for(int b=a+1; b<arr.length-1; b++)
                for(int c=b+1; c<arr.length; c++)
                    set.add(arr[a]+arr[b]+arr[c]);
        int cnt = 0;
        for(int x : set){
            cnt++;
            if(cnt == k) return x;
        }
        return res;
    }
}
