/*
* /*
* 경로 탐색(인접 행렬)
* 방향그래프가 주어지면 1번 정점에서 N번 정점으로 가는 모든 경로의 가지 수를 출력하는 프로그램을 작성하세요.
* 아래 그래프에서 1번 정점에서 5번 정점으로 가는 가지수는
*
* 1 2 3 4 5
* 1 2 5
* 1 3 4 2 5
* 1 3 4 5
* 1 4 2 5
* 1 4 5
* 총 6가지입니다.
*
* 입력설명
* 철째 줄에는 정점의 수 (N<=1<=20)와 간선의 수 M가 주어진다. 그 다음부터 M줄에 걸쳐 연결정보가 주어진다.
*
* 출력설명
* 총 가지수를 출력한다.
*
* 입력예제
5 9
1 2
1 3
1 4
2 1
2 3
2 5
3 4
4 2
4 5
*
* 출력예제
* 6
*
* */


package com.company.algorithm.rc$DFS$BFS.searchRoadAL3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<List<Integer>> arr = new ArrayList<>();
    static int[] ch;
    static int n,m,res;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        ch = new int[n+1];
        for(int i=0; i<=n; i++) arr.add(new ArrayList<>());
        for(int i=0; i<m; i++) arr.get(sc.nextInt()).add(sc.nextInt());
        ch[1] = 1;
        DFS(1);
        System.out.println(res);
    }

    private static void DFS(int i) {
        if(i==n) res++;
        else{
            for(int r : arr.get(i)){
                if(ch[r]==0){
                    ch[r] = 1;
                    DFS(i);
                    ch[r] = 0;
                }
            }
        }
    }

}
