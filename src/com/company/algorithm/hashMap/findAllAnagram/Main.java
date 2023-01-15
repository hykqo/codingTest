/*
* 4. 모든 아나그램 찾기
설명
S문자열에서 T문자열과 아나그램이 되는 S의 부분문자열의 개수를 구하는 프로그램을 작성하세요.
아나그램 판별시 대소문자가 구분됩니다. 부분문자열은 연속된 문자열이어야 합니다.

입력
첫 줄에 첫 번째 S문자열이 입력되고, 두 번째 줄에 T문자열이 입력됩니다.
S문자열의 길이는 10,000을 넘지 않으며, T문자열은 S문자열보다 길이가 작거나 같습니다.

출력
S단어에 T문자열과 아나그램이 되는 부분문자열의 개수를 출력합니다.

예시 입력 1
bacaAacba
abc

예시 출력 1
3

힌트
출력설명: {bac}, {acb}, {cba} 3개의 부분문자열이 "abc"문자열과 아나그램입니다.*/

package com.company.algorithm.hashMap.findAllAnagram;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] srr = sc.nextLine().toCharArray();
        char[] trr = sc.nextLine().toCharArray();
        HashMap<Character, Integer> mapT = new HashMap<>();
        for(char t : trr) mapT.put(t, mapT.getOrDefault(t, 0)+1);

        int res = 0, lt = 0;
        HashMap<Character, Integer> mapS = new HashMap<>();
        for(int i=0; i<trr.length; i++)  mapS.put(srr[i], mapS.getOrDefault(srr[i], 0)+1);
        if(mapT.equals(mapS)) res++;

        for(int i=trr.length; i<srr.length; i++){
            if(mapS.containsKey(srr[i])) mapS.put(srr[i], mapS.get(srr[i])+1);
            else mapS.put(srr[i], 1);
            if(mapS.get(srr[lt]) == 1) mapS.remove(srr[lt]);
            else mapS.put(srr[lt], mapS.get(srr[lt])-1);
            lt++;
            if(mapT.equals(mapS)) res++;
        }
        System.out.println(res);
    }
}
