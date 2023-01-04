package com.company.algorithm.array.rankCalculation;
/*
* 8. 등수구하기
설명
N명의 학생의 국어점수가 입력되면 각 학생의 등수를 입력된 순서대로 출력하는 프로그램을 작성하세요.
같은 점수가 입력될 경우 높은 등수로 동일 처리한다.
즉 가장 높은 점수가 92점인데 92점이 3명 존재하면 1등이 3명이고 그 다음 학생은 4등이 된다.

입력
첫 줄에 N(3<=N<=100)이 입력되고, 두 번째 줄에 국어점수를 의미하는 N개의 정수가 입력된다.

출력
입력된 순서대로 등수를 출력한다.


예시 입력 1
5
87 89 92 100 76

예시 출력 1
4 3 2 1 5
*
* 1. 순위를 저장할 변수를 만든다
* 2. 인입받은 점수들을 이용해서 2중 반복문을 돌린다.
* 3. 각 점수를 다른 점수들과 비교한다.
* 4. i의 점수가 j의 점수보다 낮을때 카운트를 1개씩 올린다.
* 5. 만약 점수가 같거나 높으면 카운트되지 않는다.
* */

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public void result(int[] arr) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i : arr){
            int cnt = 1;
            for(int j : arr){
                if(j > i) cnt++;
            }
            bw.write(cnt+" ") ;
        }
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        Main m = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());
        m.result(arr);
    }
}
