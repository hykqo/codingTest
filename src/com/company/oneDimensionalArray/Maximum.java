package com.company.oneDimensionalArray;
/*
* 문제
9개의 서로 다른 자연수가 주어질 때, 이들 중 최댓값을 찾고 그 최댓값이 몇 번째 수인지를 구하는 프로그램을 작성하시오.

예를 들어, 서로 다른 9개의 자연수

3, 29, 38, 12, 57, 74, 40, 85, 61

이 주어지면, 이들 중 최댓값은 85이고, 이 값은 8번째 수이다.

입력
첫째 줄부터 아홉 번째 줄까지 한 줄에 하나의 자연수가 주어진다. 주어지는 자연수는 100 보다 작다.

출력
첫째 줄에 최댓값을 출력하고, 둘째 줄에 최댓값이 몇 번째 수인지를 출력한다.*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Maximum {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> nList = new ArrayList<>();
        int i = 0;
        while (i < 9) {
            int x = Integer.parseInt(br.readLine());
            if (x > 100) throw new Exception("주어지는 자연수는 100 보다 작다.");
            nList.add(x);
            i++;
        }
        br.close();
        int max = Collections.max(nList);
        int index = nList.indexOf(max) + 1;

        System.out.println(max);
        System.out.print(index);
    }
}
