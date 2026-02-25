
/**
 예시 입력 1
 5
 10 13 10 12 15
 12 39 30 23 11
 11 25 50 53 15
 19 27 29 37 27
 19 13 30 13 19

 예시 출력 1
 155

 * */

package review1.array;

import java.util.Scanner;

public class GridMaxSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr = new int[n][n];

        int rowMax = 0;
        int colMax = 0;


        int diagSum = 0;
        int revsDiagSum = 0;
        int reverseIndexJ = n - 1;

        for(int i = 0; i < n; i++) {
            //가로,세로열 합 초기화
            int colSum= 0, rowSum = 0;
            for(int j = 0; j < n; j++) {
                arr[i][j] = scanner.nextInt();
                //가로열 합 구하기
                rowSum += arr[i][j];
            }

            //양 대각선 합 구하기
            diagSum += arr[i][i];
            revsDiagSum+= arr[i][reverseIndexJ];
            reverseIndexJ--;
            //열,행 max구하기.
            rowMax = Math.max(rowMax, rowSum);
        }
        //세로행은 별도 계산
        for(int j = 0; j < n; j++){
            int colSum = 0;
            for(int i=0; i<n; i++){
                colSum += arr[i][j];
            }
            colMax = Math.max(colMax, colSum);
        }

        System.out.println(Math.max(Math.max(rowMax, colMax), Math.max(diagSum, revsDiagSum)));
    }
}
