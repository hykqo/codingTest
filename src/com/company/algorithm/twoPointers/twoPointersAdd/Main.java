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

/*
* 투포인터스 문제이다. 투포인터를 활용하여 풀어야 한다.
* 포인트를 활용하기 위해 p1과p2 변수를 만든다.
* 포인터에는 각 배열의 현재 인덱스를 담아놓을 것이다.
* 1. 각 포인터를 배열의 끝까지 돌 수 있도록 반복문을 설정한다.
* 2. 반복문 안에서 a배열의 p1가 b배열의 p2보다 작으면 res배열에 a배열의 p1값을 저장시키고 p1을 1 증가한다.(다음 값을 확인할 수 있도록)
* 3. 반대라면 res배열에 b배열의 p2값을 저장시키고 p2를 1 증가한다.
* 4. 두개중의 한개 포인터라도 배열의 끝에 다다랐다면 반복문을 종료한다.
* 5. 두개중의 한개 포인터는 배열이 남았기 때문에, 반복문을 돌려서 나머지 값을 res에 저장시킨다.
* 6. 이후 res값을 호출한다.
* */

package com.company.algorithm.twoPointers.twoPointersAdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public void result(int n, int m, int[] a, int[] b){
        List<Integer> res = new ArrayList<>();
        int p1=0, p2=0;
        while (p1<n && p2<m){
            if(a[p1]<b[p2]) res.add(a[p1++]); //a[p1++] : a의 p1값을 호출하고 이후 p1의 값이 증가한다.
            else res.add(b[p2++]);
        }
        while (p1<n) res.add(a[p1++]);
        while (p2<m) res.add(b[p2++]);
        for(int r : res) System.out.print(r+" ");
    }

    public static void main(String[] args) {
        Main res = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        for(int i=0; i<n; i++) arr1[i] = sc.nextInt();
        int m = sc.nextInt();
        int[] arr2 = new int[m];
        for(int i=0; i<m; i++) arr2[i] = sc.nextInt();
        res.result(n,m,arr1,arr2);
    }
}
