package com.company.loop;
/*문제
두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.

입력
입력은 여러 개의 테스트 케이스로 이루어져 있다.

각 테스트 케이스는 한 줄로 이루어져 있으며, 각 줄에 A와 B가 주어진다. (0 < A, B < 10)

출력
각 테스트 케이스마다 A+B를 출력한다.*/

import java.io.*;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class APlusBMinusFour {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        while (true){
            System.out.println(a+b);
            str = br.readLine();
            if(str == null) break;
            try {
                st = new StringTokenizer(str, " ");
            }catch (NoSuchElementException e){
                break;
            }
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
        }
        br.close();
    }
}
