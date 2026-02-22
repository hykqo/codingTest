/**
 3. 가위 바위 보
 설명
 A, B 두 사람이 가위바위보 게임을 합니다. 총 N번의 게임을 하여 A가 이기면 A를 출력하고, B가 이기면 B를 출력합니다. 비길 경우에는 D를 출력합니다.
 가위, 바위, 보의 정보는 1:가위, 2:바위, 3:보로 정하겠습니다.
 예를 들어 N=5이면 5회차동안 두사람이 가위 바위보를 해서 결과를 A,B,D로 출력하면 되겠습니다.
 두 사람의 각 회의 가위, 바위, 보 정보가 주어지면 각 회를 누가 이겼는지 출력하는 프로그램을 작성하세요.


 입력
 첫 번째 줄에 게임 횟수인 자연수 N(1<=N<=100)이 주어집니다.
 두 번째 줄에는 A가 낸 가위, 바위, 보 정보가 N개 주어집니다.
 세 번째 줄에는 B가 낸 가위, 바위, 보 정보가 N개 주어집니다.


 출력
 각 줄에 각 회의 승자를 출력합니다. 비겼을 경우는 D를 출력합니다.


 예시 입력 1
 5
 2 3 3 1 3
 1 1 2 2 3

 예시 출력 1
 A
 B
 A
 B
 D
 * */

package review1.array;

import java.util.Scanner;

public class RockPaper {

    public static char rockPaperScissors(int a, int b){
        char A = 'A'
           , B = 'B'
           , D = 'D';
        if(a == b) return D;
        else if(a == 1 && b == 3) return A;
        else if(a == 2 && b == 1) return A;
        else if(a == 3 && b == 2) return A;
        else return B;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        int[] arrA = new int[num];
        for(int i=0; i<num; i++) arrA[i] = scanner.nextInt();
        int[] arrB = new int[num];
        for(int i=0; i<num; i++) arrB[i] = scanner.nextInt();

        char[] result = new char[num];

        for(int i=0; i<num; i++){
            result[i] = rockPaperScissors(arrA[i], arrB[i]);
        }
        for(char c : result) System.out.println(c);
    }
}
