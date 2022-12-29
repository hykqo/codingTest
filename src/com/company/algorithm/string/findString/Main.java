package com.company.algorithm.string.findString;

import java.util.Scanner;
/*1. 문자 찾기
설명

한 개의 문자열을 입력받고, 특정 문자를 입력받아 해당 특정문자가 입력받은 문자열에 몇 개 존재하는지 알아내는 프로그램을 작성하세요.

대소문자를 구분하지 않습니다.문자열의 길이는 100을 넘지 않습니다.


입력
첫 줄에 문자열이 주어지고, 두 번째 줄에 문자가 주어진다.

문자열은 영어 알파벳으로만 구성되어 있습니다.


출력
첫 줄에 해당 문자의 개수를 출력한다.


예시 입력 1

Computercooler
c
예시 출력 1
2
*/

public class Main {
    public int solution(String str, char t){
        int res = 0;
        str = str.toUpperCase();//대소문자를 구분하지 않고 search해야 하므로 전부 대문자로 바꿔주자
        t = Character.toUpperCase(t); //char문자 형식이기 때문에 Character를 사용하자
//        for(int i = 0; i<str.length(); i++) {
//            //문자열의 인덱스를 접근해보자 charAt(i)를 사용해보면 된다.
//            if(str.charAt(i) == t) res++;
//        }
        //문자를 문자열로 변경하는법 toCharArray() 향상된 for문이 좀 더 빠르다.
        for(char x : str.toCharArray()) if(x==t) res++;
        return res;
    }
    public static void main(String[] args) {
        Main t = new Main();
        Scanner sc = new Scanner(System.in);
        String init1 = sc.next();
        char init2 = sc.next().charAt(0);
        System.out.println(t.solution(init1, init2));
    }
}
