package review1.dynamicProgramming;

//최대 점수 구하기 냅색 알고리즘

import java.util.Scanner;

/*
5 20

10 5
25 12
15 8
6 3
7 4
* */
public class FindTheHighestScore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] dy = new int[m+1];
        for(int i=0; i<n; i++) {
            int score = scanner.nextInt();
            int time = scanner.nextInt();
            for (int j=m; j>=time; j--) {
                dy[j] = Math.max(dy[j], dy[j-time] + score);
            }
        }
        System.out.println(dy[m]);
    }
}
