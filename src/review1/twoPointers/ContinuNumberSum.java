package review1.twoPointers;

import java.util.Scanner;

public class ContinuNumberSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = (n / 2) + 1;

        int point1 = 0;
        int point2 = 0;
        int calSum = 0;
        int resCnt = 0;
        while (true){
            if(point2 > m) break;
            if(calSum <= n) calSum += ++point2;
            else calSum -= point1++;
            if(calSum == n) resCnt++;
        }
        System.out.println(resCnt);
    }
}
