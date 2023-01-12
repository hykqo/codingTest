/*1. 학급 회장(해쉬)
설명
학급 회장을 뽑는데 후보로 기호 A, B, C, D, E 후보가 등록을 했습니다.
투표용지에는 반 학생들이 자기가 선택한 후보의 기호(알파벳)가 쓰여져 있으며 선생님은 그 기호를 발표하고 있습니다.
선생님의 발표가 끝난 후 어떤 기호의 후보가 학급 회장이 되었는지 출력하는 프로그램을 작성하세요.
반드시 한 명의 학급회장이 선출되도록 투표결과가 나왔다고 가정합니다.

입력
첫 줄에는 반 학생수 N(5<=N<=50)이 주어집니다.
두 번째 줄에 N개의 투표용지에 쓰여져 있던 각 후보의 기호가 선생님이 발표한 순서대로 문자열로 입력됩니다.

출력
학급 회장으로 선택된 기호를 출력합니다.

예시 입력 1
15
BACBACCACCBDEDE

예시 출력 1
C
*/
package com.company.algorithm.hashMap.studentPresident2;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private void result(int n, String s) {
        char res = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        //getOrDefault 특정카의 밸류가 없으면 default값을 가져오기.
        for(char k: s.toCharArray()) map.put(k, map.getOrDefault(k, 0)+1);
        //keySet()은 key만 모아놓은 배열이다.
        int max = Integer.MIN_VALUE;
        for(char k : map.keySet()) {
            if(map.get(k) > max){
                max = map.get(k);
                res = k;
            }
        }
        System.out.println(res);
    }


    public static void main(String[] args) {
        Main m =new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        m.result(n, s);
    }
}
