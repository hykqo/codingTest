/*
* 3. 가위 바위 보
설명
A, B 두 사람이 가위바위보 게임을 합니다. 총 N번의 게임을 하여 A가 이기면 A를 출력하고, B가 이기면 B를 출력합니다. 비길 경우에는 D를 출력합니다.
가위, 바위, 보의 정보는 1:가위, 2:바위, 3:보로 정하겠습니다.

예를 들어 N=5이면
회수      1   2   3   4   5
============================
A의정보    2   3   3   1   3
B의정보    1   1   2   2   3
============================
승자      A   B   A   B   D

두 사람의 각 회의 가위, 바위, 보 정보가 주어지면 각 회를 누가 이겼는지 출력하는 프로그램을 작성하세요.


입력
첫 번째 줄에 게임 횟수인 자연수 N(1<=N<=100)이 주어집니다.
두 번째 줄에는 A가 낸 가위, 바위, 보 정보가 N개 주어집니다.
세 번째 줄에는 B가 낸 가위, 바위, 보 정보가 N개 주어집니다.


출력
각 줄에 각 회의 승자를 출력합니다. 비겼을 경우는 D를 출력합니다.


예시 입력 1
5
2 3 3 1 3
1 1 2 2 3

예시 출력 1
A
B
A
B
D*/
package com.company.algorithm.array.rockPaperScissors;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public void result(int n, StringTokenizer ast, StringTokenizer bst, BufferedWriter bw) throws IOException {
        for(int i =0; i<n; i++)  {
            int a = Integer.parseInt(ast.nextToken());
            int b = Integer.parseInt(bst.nextToken());
            //1:가위, 2:바위, 3:보
            if(a == 1){
                if(b == 1) bw.write("D\n");
                else if(b == 2) bw.write("B\n");
                else if(b == 3) bw.write("A\n");
            }
            else if(a == 2){
                if(b == 1) bw.write("A\n");
                else if(b == 2) bw.write("D\n");
                else if(b == 3) bw.write("B\n");
            }
            else if(a == 3){
                if(b == 1) bw.write("B\n");
                else if(b == 2) bw.write("A\n");
                else if(b == 3) bw.write("D\n");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main m = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer ast = new StringTokenizer(br.readLine());
        StringTokenizer bst = new StringTokenizer(br.readLine());
        br.close();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        m.result(n, ast, bst, bw);
        bw.flush();
        bw.close();
    }
}
