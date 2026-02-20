
/**
 1. 큰 수 출력하기
 설명
 N개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력하는 프로그램을 작성하세요.
 (첫 번째 수는 무조건 출력한다)

 입력
 첫 줄에 자연수 N(1<=N<=100)이 주어지고, 그 다음 줄에 N개의 정수가 입력된다.

 출력
 자신의 바로 앞 수보다 큰 수만 한 줄로 출력한다.


 예시 입력 1
 6
 7 3 9 5 6 12

 예시 출력 1
 7 9 6 12

 * */
package review1.array;

import java.util.Scanner;

public class PrintBigNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numLength = Integer.parseInt(scanner.nextLine());
        String initNum = scanner.nextLine();
        String[] strNum = initNum.split(" ");

        String answer = "";
        for(int i = 0; i < numLength; i++){
            if(i == 0) answer += strNum[i] + " ";
            else{
                int s = Integer.parseInt(strNum[i].replace(" ",""));
                int n = Integer.parseInt(strNum[i-1].replace(" ",""));
                if(s > n) answer += strNum[i] + " ";
            }
        }
        System.out.println(answer);
    }
}
