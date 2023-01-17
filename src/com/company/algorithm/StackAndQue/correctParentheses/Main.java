package com.company.algorithm.stackAndQue.correctParentheses;

import java.util.Scanner;

/*
* 1. 올바른 괄호
설명
괄호가 입력되면 올바른 괄호이면 “YES", 올바르지 않으면 ”NO"를 출력합니다.
(())() 이것은 괄호의 쌍이 올바르게 위치하는 거지만, (()()))은 올바른 괄호가 아니다.

입력
첫 번째 줄에 괄호 문자열이 입력됩니다. 문자열의 최대 길이는 30이다.

출력
첫 번째 줄에 YES, NO를 출력한다.

예시 입력 1
(()(()))(()

예시 출력 1
NO
*/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pt = sc.next();
        int x = 0;
        char[] clist = pt.toCharArray();
        if(clist[0] == 41 || clist[clist.length-1] == 40) System.out.println("NO");
        else{
            for(char c : clist){
                if(c == 40) x++;
                else x--;
            }
            if(x == 0) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
