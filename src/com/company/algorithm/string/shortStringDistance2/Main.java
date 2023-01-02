package com.company.algorithm.string.shortStringDistance2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/*
* 10. 가장 짧은 문자거리
설명
한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.

입력
첫 번째 줄에 문자열 s와 문자 t가 주어진다. 문자열과 문자는 소문자로만 주어집니다.
문자열의 길이는 100을 넘지 않는다.

출력
첫 번째 줄에 각 문자열 s의 각 문자가 문자 t와 떨어진 거리를 순서대로 출력한다.


예시 입력 1
teachermode e

예시 출력 1
1 0 1 2 1 0 1 2 2 1 0


0 1 2 3 3 2 1 0 1 2 3 4 5 6 5 4 3 2 1 0 1 2 3 2 1 0 1 2
0 1 2 3 3 2 1 0 1 2 3 4 5 6 5 4 3 2 1 0 1 2 3 2 1 0 1 1


*
*
*/
public class Main {
    public Integer[] result(String str, char c){
        int x = 1000;
        Integer[] ints = new Integer[str.length()];
        for(int i =0; i < str.length(); i++){
            if(str.charAt(i) == c) {
                x = 0;
                ints[i] = x;
            }
            else{
                x++;
                ints[i] = x;
            }
        }
        x = 1000;
        for(int i = str.length()-1; i >= 0; i--){
            if(ints[i] == 0) x = 0;
            else {
                x++;
                ints[i] = Math.min(ints[i], x);
            }
        }
        return ints;
    }

    public static void main(String[] args) throws IOException {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char c = sc.next().charAt(0);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(Integer i : m.result(str, c)) bw.write(i+" ");
        bw.flush();
        bw.close();
    }
}
