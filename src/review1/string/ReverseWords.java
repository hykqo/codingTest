package review1.string;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 4. 단어 뒤집기

 설명
 N개의 단어가 주어지면 각 단어를 뒤집어 출력하는 프로그램을 작성하세요.

 입력
 첫 줄에 자연수 N(3<=N<=20)이 주어집니다.
 두 번째 줄부터 N개의 단어가 각 줄에 하나씩 주어집니다. 단어는 영어 알파벳으로만 구성되어 있습니다.


 출력
 N개의 단어를 입력된 순서대로 한 줄에 하나씩 뒤집어서 출력합니다.

 예시 입력 1
 3
 good
 Time
 Big

 예시 출력 1
 doog
 emiT
 giB


* */
public class ReverseWords {

    public void solution(String[] str) {
//        for(String s : str){
//            StringBuilder result = new StringBuilder(s);
//            System.out.println(result.reverse());
//        }
        for(String s: str){
            char[] charArray = s.toCharArray();
            int lt = 0;
            int rt = s.length()-1;
            while(lt < rt){
                char tmp = charArray[lt];
                charArray[lt] = charArray[rt];
                charArray[rt] = tmp;
                lt++;
                rt--;
            }
            String result = String.valueOf(charArray);
            System.out.println(result);
        }
    }

    public static void main(String[] args) {
        ReverseWords reverseWords = new ReverseWords();
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        String[] str = new String[k];
        for(int i = 0; i< k; i++){
            str[i] = scanner.next();
        }
        reverseWords.solution(str);
    }
}
