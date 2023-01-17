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
package com.company.basicMath.findPrimeNumber2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = n; i <= m; i++) {
            if(i==1) continue;
            boolean bool = true;
            for(int j=2; j<i; j++)
                if(i%j==0) {
                    bool = false;
                    break;
                }
            if(bool) bw.write(i);
        }
        bw.flush();
        bw.close();
    }
}
