package review1.twoPointers.slidingWindow;

import java.util.Scanner;

public class MaxSales {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] totalSales = new int[n];

        for(int i=0; i<n; i++) totalSales[i] = scanner.nextInt();


        //default값 셋팅
        int point1 = 0;
        int point2 = k-1;
        int max = 0;
        for(int i=0; i<k; i++) max += totalSales[i];

        //탐색
        int calcSum = max;
        for(int i=0; i<n-k; i++){
            calcSum -= totalSales[point1++];
            calcSum += totalSales[++point2];

            max = Math.max(max, calcSum);
        }
        System.out.println(max);

    }
}
