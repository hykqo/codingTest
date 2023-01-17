/*
* 소수 구하기
문제
M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. (1 ≤ M ≤ N ≤ 1,000,000) M이상 N이하의 소수가 하나 이상 있는 입력만 주어진다.

출력
한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.

예제 입력 1
3 16
예제 출력 1
3
5
7
11
13
*/
package com.company.basicMath.findPrimeNumber3;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[] arr = new boolean[m+1];
        StringBuilder sb = new StringBuilder();
        for(int i=2; i<=m; i++){
            if(!arr[i]){
                if(i >= n) sb.append(i+"\n");
                for(int j=i+i; j<=m; j=j+i) arr[j] = true;
            }
        }
        System.out.println(sb);
    }
}
