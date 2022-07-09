package com.company.stringArg;
/*문제
알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오. 단, 대문자와 소문자를 구분하지 않는다.

입력
첫째 줄에 알파벳 대소문자로 이루어진 단어가 주어진다. 주어지는 단어의 길이는 1,000,000을 넘지 않는다.

출력
첫째 줄에 이 단어에서 가장 많이 사용된 알파벳을 대문자로 출력한다. 단, 가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 ?를 출력한다.*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class WordStudy {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] sList = br.readLine().toCharArray();
        Map<String, Integer> resList = new HashMap<>();
        for(byte i = 65; i < 91; i++){
            int num = 0;
            String key = null;
            for(char s : sList){
               if(i == (byte) s || i+32 == (byte) s) {
                   num += 1;
                   key = String.valueOf(s);
               }
            }
            resList.put(key, num);
        }
        List<Map.Entry<String , Integer>> entries = new LinkedList<>(resList.entrySet());
        Comparator<Map.Entry<String, Integer>> cmp = Map.Entry.comparingByValue();
        entries.sort(cmp.reversed());
        if(entries.size() > 2) {
            if(entries.get(0).getValue() == entries.get(1).getValue()) System.out.print("?");
            else System.out.println(entries.get(0).getKey().toUpperCase(Locale.ROOT));
        }
        else System.out.println(entries.get(0).getKey().toUpperCase(Locale.ROOT));
    }
}
