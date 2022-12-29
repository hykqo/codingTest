package com.company.algorithm.string.caseConversion;

/*2. 대소문자 변환
설명

대문자와 소문자가 같이 존재하는 문자열을 입력받아 대문자는 소문자로 소문자는 대문자로 변환하여 출력하는 프로그램을 작성하세요.


입력
첫 줄에 문자열이 입력된다. 문자열의 길이는 100을 넘지 않습니다.

문자열은 영어 알파벳으로만 구성되어 있습니다.


출력
첫 줄에 대문자는 소문자로, 소문자는 대문자로 변환된 문자열을 출력합니다.


예시 입력 1
StuDY
예시 출력 1
sTUdy*/

import java.util.Scanner;

public class Main {
    public String solution(String str){
        String res = "";
        for(char t : str.toCharArray()) {
            //Character.isLowerCase(t) 단일문자가 소문자인지 체크 true false 반환
            //Character.isLowerCase(t) 단일문자가 대문자인지 체크 true false 반환
//            if(Character.isLowerCase(t)) res += Character.toUpperCase(t);
//            else res+= Character.toLowerCase(t);

            //아스키 코드로 확인 대문자는(65~90) 소문자는(97~122)임.
            //대문자와 소문자의 차이는 32임. 32를 +-하면 변환을 할 수 있음.
            //캐릭터는 정수형이다.
            //대문자
            if(t >= 65 && t <= 90) res += (char)(t+32);
            else if(t >= 97 && t <= 122) res += (char)(t-32);
            //아스키보다 자바 내장함수를 쓰는게 더 빠르다 아마도 형변환때문에 그런게 아닌가 싶다.
        }
        return res;
    }

    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(m.solution(str));
    }
}
