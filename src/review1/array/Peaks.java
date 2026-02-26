/**

 예시 입력 1
 5
 5 3 7 2 3
 3 7 1 6 1
 7 2 5 3 4
 4 3 6 4 1
 8 7 3 5 2

 예시 출력 1
 10

 */

package review1.array;

import java.util.Scanner;

public class Peaks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int cnt = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                boolean up, down, left, right;
                if(i==0) up = true;
                else up = arr[i-1][j] < arr[i][j];

                if(j==0) left = true;
                else left = arr[i][j-1] < arr[i][j];

                if(i==n-1)  down = true;
                else down = arr[i+1][j] < arr[i][j];

                if(j==n-1) right = true;
                else right = arr[i][j+1] < arr[i][j];
                if(up && down && left && right) cnt++;
            }
        }
        System.out.println(cnt);
    }
}
