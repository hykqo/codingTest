package com.company.loop;
/*문제
n이 주어졌을 때, 1부터 n까지 합을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 n (1 ≤ n ≤ 10,000)이 주어진다.

출력
1부터 n까지 합을 출력한다.*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Plus {

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n < 1 || n > 10000) throw new Exception("n (1 ≤ n ≤ 10,000)");
        int res = 0;
        for(int i = 1; i <= n; i++) res = res + i;
        System.out.println(res);
    }
}
