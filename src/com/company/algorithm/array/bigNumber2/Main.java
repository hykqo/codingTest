package com.company.algorithm.array.bigNumber2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

/*
* 1. 큰 수 출력하기
설명

N개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력하는 프로그램을 작성하세요.

(첫 번째 수는 무조건 출력한다)


입력
첫 줄에 자연수 N(1<=N<=100)이 주어지고, 그 다음 줄에 N개의 정수가 입력된다.


출력
자신의 바로 앞 수보다 큰 수만 한 줄로 출력한다.


예시 입력 1
6
7 3 9 5 6 12

예시 출력 1
7 9 6 12
* */
public class Main {
    public ArrayList<Integer> result(int n, int[] inits){
    ArrayList<Integer> res = new ArrayList<>();
    res.add(inits[0]);
    for(int i =1; i<n; i++){
        if(inits[i]>inits[i-1]) res.add(inits[i]);
    }
    return res;
    }

    public static void main(String[] args) throws IOException {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] inits = new int[n];
        for(int i =0; i < n; i++) inits[i] = sc.nextInt();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int x : m.result(n, inits)) bw.write(x+" ");
        bw.flush();
        bw.close();
    }
}
