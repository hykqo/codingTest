/**
 11. 문자열 압축
 설명
 알파벳 대문자로 이루어진 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우 반복되는
 문자 바로 오른쪽에 반복 횟수를 표기하는 방법으로 문자열을 압축하는 프로그램을 작성하시오.
 단 반복횟수가 1인 경우 생략합니다.


 입력
 첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.


 출력
 첫 줄에 압축된 문자열을 출력한다.


 예시 입력 1
 KKHSSSSSSSE

 예시 출력 1
 K2HS7E

 예시 입력 2
 KSTTTSEEKFKKKDJJGG

 예시 출력 2
 KST3SE2KFK3DJ2G2
 * */

package review1.string;

import java.util.Scanner;

public class StringCompression {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        //첫번째 문자는 이미 카운트
        int compressed = 1;
        char compressThisChar = str.charAt(0); //압축 진행중인 char

        for(int i = 1; i < str.length(); i++){
            char c = str.charAt(i);

            //압축 진행중인 문자와 현재의 문자가 동일하면 압축 횟수 증가
            if(compressThisChar == c){
                compressed++;
            }
            //다른 문자가 나타나면 이전 문자와 압축 횟수 출력 후 새 문자로 압축 시작
            else {
                System.out.print(compressThisChar);
                if(compressed > 1) System.out.print(compressed);
                compressThisChar = c;
                compressed = 1; // 새 문자의 카운트 1로 시작
            }
        }

        //마지막 문자 처리
        System.out.print(compressThisChar);
        if(compressed > 1) System.out.print(compressed);
    }
}
