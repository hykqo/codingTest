package review1.dynamicProgramming;

import java.util.Scanner;

/*
최대 부분 증가 수열(LIS)
8
5 3 7 8 6 2 9 4
* */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scanner.nextInt();
        }

        int[] dy = new int[n];
        dy[0] = 1;
        int answer = 1;
        for(int i=1; i<n; i++){
            int max = 0;
            for(int j=i-1; j>=0; j--){
                if(arr[j] < arr[i] && dy[j] > max){
                    max = dy[j];
                }
            }
            dy[i] = max+1;
            answer = Math.max(answer, dy[i]);
        }
        System.out.println(answer);
    }


}
