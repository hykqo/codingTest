package com.company.algorithm.string.wordInSentence;

import java.util.Scanner;

/*3. 문장 속 단어
설명

한 개의 문장이 주어지면 그 문장 속에서 가장 긴 단어를 출력하는 프로그램을 작성하세요.

문장속의 각 단어는 공백으로 구분됩니다.


입력
첫 줄에 길이가 100을 넘지 않는 한 개의 문장이 주어집니다. 문장은 영어 알파벳으로만 구성되어 있습니다.


출력
첫 줄에 가장 긴 단어를 출력한다. 가장 길이가 긴 단어가 여러개일 경우 문장속에서 가장 앞쪽에 위치한

단어를 답으로 합니다.


예시 입력 1
it is time to study
예시 출력 1
study
*/
public class Main {
    public String solution(String str){
        String res = "";
        //가장 작은수로 초기화 -2의 31제곱
        int m = Integer.MIN_VALUE;

        //단어별로 잘라서 가장 긴 문자를 반환해보자
//        String[] s = str.split(" ");
//        for(String x:s) {
//            int len = x.length();
//            if(len > m) {
//                m = len;
//                res = x;
//            }
//        }

        //indexOf()를 사용해서 구현해보자.
        int pos;
        //indexOf가 띄어쓰기를 발견하지 못하면 -1를 리턴한다. indexOf는 첫번째로 발견되는것을 리턴한다 발견하면 해당 위치를 반환한다
        while ((pos=str.indexOf(" ")) != -1){
            String tmp = str.substring(0, pos);
            int len = tmp.length();
            if(len > m){
                m = len;
                res = tmp;
            }
            str = str.substring(pos+1); //pos+1부터 끝까지 자르기
        }
        //마지막 단어는 indexOf(" ")로 추출하지 못함 왜냐하면 마지막 단어 뒤에 " "이 없으니까. 그래서 while문이 완료된 후 마지막 단어를 처리해주어야 함.
        if(str.length() > m) res = str;
        return res;
    }

    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        //문장을 입력받아야 하기 때문에, nextLine()으로 받아야 함. 문자는 next()만 입력한다.
        String str = sc.nextLine();
        System.out.println(m.solution(str));
    }
}
