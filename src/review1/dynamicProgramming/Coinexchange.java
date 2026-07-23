package review1.dynamicProgramming;
//동전교환 냅색 알고리즘

/*
3
1 2 5
15
* */
import java.util.Scanner;

public class Coinexchange {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] coinArr = new int[n];
        for (int i=0; i<n; i++) coinArr[i] = scanner.nextInt();
        int m = scanner.nextInt();
        int[] dy = new int[m+1];

        for (int i=0; i<n; i++) {
            int coin = coinArr[i];
            for (int j=coin; j<=m; j++) {
                dy[j] = Math.min(dy[j], dy[j - coin] + 1);
            }
        }
        System.out.println(dy[m]);
    }
}
