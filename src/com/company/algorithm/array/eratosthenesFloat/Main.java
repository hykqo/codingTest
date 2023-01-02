/*
* 5. 소수(에라토스테네스 체)
설명
자연수 N이 입력되면 1부터 N까지의 소수의 개수를 출력하는 프로그램을 작성하세요.
만약 20이 입력되면 1부터 20까지의 소수는 2, 3, 5, 7, 11, 13, 17, 19로 총 8개입니다.

입력
첫 줄에 자연수의 개수 N(2<=N<=200,000)이 주어집니다.

출력
첫 줄에 소수의 개수를 출력합니다.


예시 입력 1
20

예시 출력 1
8*/


package com.company.algorithm.array.eratosthenesFloat;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
  0. 동적배열은 0으로 다 초기화 된다. 해당 숫자만큼의 배열을 만들어준다.
* 1. 2~n까지를 반복하면서 자기자신을 카운팅 한 후 자기의 베수는 전부 체크(1)해버린다.
* 2. 카운팅을 표시한다.*/
public class Main {
    public int result(int n){
        int res = 0;

        int[] ch = new int[n+1];
        for(int i = 2; i<=n; i++){
            if(ch[i]==0){
                res++;
                for(int j=i; j<=n; j=j+i) ch[j] = 1;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(m.result(n));
    }
}
