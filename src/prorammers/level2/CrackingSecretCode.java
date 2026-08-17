package prorammers.level2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*

10
1 2 3 4 5
6 7 8 9 10
3 7 8 9 10
2 5 7 9 10
3 4 5 6 7

2 3 4 3 3

* */
public class CrackingSecretCode {

        static int solution(int n, int[][] q, int[] ans) {
            int answer = 0;
            for (int a = 1; a <= n - 4; a++) {
                for (int b = a + 1; b <= n - 3; b++) {
                    for (int c = b + 1; c <= n - 2; c++) {
                        for (int d = c + 1; d <= n - 1; d++) {
                            for (int e = d + 1; e <= n; e++) {
                                if (isPossible(a, b, c, d, e, q, ans)) {
                                    answer++;
                                }
                            }
                        }
                    }
                }
            }

            return answer;
        }


        static boolean isPossible(
        int a,
        int b,
        int c,
        int d,
        int e,
        int[][] q,
        int[] ans
    ) {
            for (int i = 0; i < q.length; i++) {
                int count = 0;
                for (int num : q[i]) {
                    if (num == a
                            || num == b
                            || num == c
                            || num == d
                            || num == e) {
                        count++;
                    }
                }

                if (count != ans[i]) {
                    return false;
                }
            }

            return true;
        }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] q = new int[n][5];
        for (int i=0; i<n; i++){
            for (int j=0; j<5; j++){
                q[i][j] = scanner.nextInt();
            }
        }
        int[] ans = new int[n];
        for (int i=0; i<5; i++){
            ans[i] = scanner.nextInt();
        }
        System.out.println(solution(n, q, ans));
    }
}
