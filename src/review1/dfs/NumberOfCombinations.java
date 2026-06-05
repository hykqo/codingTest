package review1.dfs;

import java.util.Scanner;

public class NumberOfCombinations {
    static int[][] memoi;

    static int DFS(int n, int r){
        if(n == r || r == 0) return 1;
        else {
            if(memoi[n][r] != 0) return memoi[n][r];
            else return memoi[n][r] = DFS(n-1, r-1) + DFS(n-1, r);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int r = scanner.nextInt();
        memoi = new int[n+1][n+1];
        //5C3
        System.out.println(DFS(n, r));


    }

}
