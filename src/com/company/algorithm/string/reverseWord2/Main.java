package com.company.algorithm.string.reverseWord2;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/*
4. 단어 뒤집기
설명

N개의 단어가 주어지면 각 단어를 뒤집어 출력하는 프로그램을 작성하세요.


입력
첫 줄에 자연수 N(3<=N<=20)이 주어집니다.

두 번째 줄부터 N개의 단어가 각 줄에 하나씩 주어집니다. 단어는 영어 알파벳으로만 구성되어 있습니다.


출력
N개의 단어를 입력된 순서대로 한 줄에 하나씩 뒤집어서 출력합니다.


예시 입력 1
3
good
Time
Big

예시 출력 1
doog
emiT
giB
*/
public class Main {
    public ArrayList<String> solution(int n, String[] str){
        ArrayList<String> res = new ArrayList<>();
        for(String s : str) {
            //String이라는 객체는 변경할 수 없는 불변의 객체이기 때문에, String을 변경하는 행위는 전부 객체를 새로 생성해서 동작한다.
            //하지만 StringBuilder를 사용하면 객체를 새로 생성하지 않고 가지고 있는 객체를 대상으로 변경한다.
            //따라서 String으로 뭔가를 많이 한다면 StringBuilder를 활용하자.
            //char[]로 처리하는것 보다 훨씬 더 빠르다. StringBuilder의 힘인가보다.
            String tmp = new StringBuilder(s).reverse().toString();
            res.add(tmp);

            //char리스트로 변화하여 특정 문자들을 뒤집을 수 있는 기능도 있다.
//            char[] xList = s.toCharArray();
//            int lt = 0;
            //마지막 index값
//            int rt = xList.length-1;
//            while (lt<rt){
//                char tmp = xList[lt];
//                xList[lt]=xList[rt];
//                xList[rt]=tmp;
//                lt++;
//                rt--;
//            }
            //문자화 valueOf()는 스태틱 메소드다.
//            String tmp = String.valueOf(xList);
//            res.add(tmp);
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] str =new String[n];
        for(int i=0; i<n; i++) str[i]=sc.next();
        for(String x : m.solution(n, str)) System.out.println(x);
    }
}
