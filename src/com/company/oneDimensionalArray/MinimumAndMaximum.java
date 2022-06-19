package com.company.oneDimensionalArray;
/*문제
N개의 정수가 주어진다. 이때, 최솟값과 최댓값을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 정수의 개수 N (1 ≤ N ≤ 1,000,000)이 주어진다. 둘째 줄에는 N개의 정수를 공백으로 구분해서 주어진다. 모든 정수는 -1,000,000보다 크거나 같고, 1,000,000보다 작거나 같은 정수이다.

출력
첫째 줄에 주어진 정수 N개의 최솟값과 최댓값을 공백으로 구분해 출력한다.*/


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class MinimumAndMaximum {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(br.readLine());
        if(n < -1000000 || n > 1000000) throw new Exception("N (1 ≤ N ≤ 1,000,000)");
        StringTokenizer st = new StringTokenizer(br.readLine());
        if(st.countTokens() != n) throw new Exception(n+"개의 정수만 입력가능합니다.");
        ArrayList x = new ArrayList();
        while (st.hasMoreTokens()) x.add(Integer.parseInt(st.nextToken()));
        System.out.println(Collections.min(x)+" "+Collections.max(x));
    }
}
