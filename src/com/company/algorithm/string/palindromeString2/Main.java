package com.company.algorithm.string.palindromeString2;

import java.util.Scanner;

/*7. 회문 문자열
설명

앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 회문 문자열이라고 합니다.

문자열이 입력되면 해당 문자열이 회문 문자열이면 "YES", 회문 문자열이 아니면 “NO"를 출력하는 프로그램을 작성하세요.

단 회문을 검사할 때 대소문자를 구분하지 않습니다.


입력
첫 줄에 길이 100을 넘지 않는 공백이 없는 문자열이 주어집니다.


출력
첫 번째 줄에 회문 문자열인지의 결과를 YES 또는 NO로 출력합니다.


예시 입력 1
gooG

예시 출력 1
YES
*/
public class Main {
    public String result(String str){

        //길이를 2로 나눈 목까지도는것으로 처리
//        String res = "YES";
//        str = str.toUpperCase();
//        int len = str.length();
//        for(int i = 0; i < len/2; i++){
//            if(str.charAt(i) != str.charAt(len-1-i)) return "NO";
//        }
//        return res;

        //StringBuilder.reverse와 equals()사용 equals는 대소문자를 구분하기 떄문에 equalsIgnoreCase를 사용하자
        String tmp = new StringBuilder(str).reverse().toString();
        if(str.equalsIgnoreCase(tmp)) return "YES";
        else return "NO";
    }

    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(m.result(str));
    }
}
