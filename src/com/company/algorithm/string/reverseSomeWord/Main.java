package com.company.algorithm.string.reverseSomeWord;

import java.util.Scanner;

/*
* 5. 특정 문자 뒤집기
설명

영어 알파벳과 특수문자로 구성된 문자열이 주어지면 영어 알파벳만 뒤집고,

특수문자는 자기 자리에 그대로 있는 문자열을 만들어 출력하는 프로그램을 작성하세요.


입력
첫 줄에 길이가 100을 넘지 않는 문자열이 주어집니다.


출력
첫 줄에 알파벳만 뒤집힌 문자열을 출력합니다.


예시 입력 1
a#b!GE*T@S

예시 출력 1
S#T!EG*b@a
* */
public class Main {
    public String solution(String str){
        char[] chars = str.toCharArray();
        int lt = 0;
        int rt = chars.length - 1;
        while (lt<rt){
            //왼쪽의 char이 알파벳이 아닌지 체크. 알파벳이 아니라면 한칸 이동
            if(!Character.isAlphabetic(chars[lt])) lt++;
                //오른쪽의 char이 알파벳이 아닌지 체크.  알파벳이 아니라면 한칸 이동
            else if(!Character.isAlphabetic(chars[rt])) rt--;
            else {
                char tmp = chars[lt];
                chars[lt] = chars[rt];
                chars[rt] = tmp;
                lt++;
                rt--;
            }
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        String init = sc.next();
        System.out.println(m.solution(init));
    }
}
