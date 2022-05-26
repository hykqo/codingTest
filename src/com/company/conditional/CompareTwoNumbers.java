package com.company.conditional;
/*문제
두 정수 A와 B가 주어졌을 때, A와 B를 비교하는 프로그램을 작성하시오.

입력
첫째 줄에 A와 B가 주어진다. A와 B는 공백 한 칸으로 구분되어져 있다.

출력
첫째 줄에 다음 세 가지 중 하나를 출력한다.

A가 B보다 큰 경우에는 '>'를 출력한다.
A가 B보다 작은 경우에는 '<'를 출력한다.
A와 B가 같은 경우에는 '=='를 출력한다.
제한
-10,000 ≤ A, B ≤ 10,000*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CompareTwoNumbers {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str =  br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        if(st.countTokens() != 2) throw new Exception("숫자는 공백을 이용해서 2개 입력 바랍니다.");
        int a = 0;
        int b = 0;
        try {
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
        }catch (NumberFormatException e){
            throw new NumberFormatException("숫자로 입력 바립니다.");
        }catch (Exception e){
            throw new Exception("잘못된 값을 입력하셨습니다.");
        }

        if(a < -10000 || a > 10000 || b < -10000 || b > 10000) throw new Exception("입력 허용값을 초과했습니다.");
        if(a < -10000) throw new Exception("입력 허용값을 초과했습니다.");
        if(a > b) System.out.println(">");
        else if(a < b) System.out.println("<");
        else if(a == b) System.out.println("==");
    }
}
