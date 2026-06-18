package review1.dfs;

import java.util.Scanner;

public class FindingCombinations {
    static int n, m;
    static int[] combi;

    public void DFS(int idx, int s) {
        if (idx == m) {
            for (int x : combi) System.out.print(x + " ");
            System.out.println();
        } else {
            for (int i = s; i <= n; i++) {
                combi[idx] = i;
                DFS(idx + 1, i + 1);
            }
        }
    }
    public static void main(String[] args) {
        FindingCombinations T = new FindingCombinations();
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        combi = new int[m];
        T.DFS(0, 1);
    }
}
