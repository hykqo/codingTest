package review1.dfs;

import java.util.Scanner;

public class fibonacciWithMemoization {
    static int[] fibo;
    public static int DFS(int n){
        if(fibo[n] > 0) return fibo[n]; //memoization
        else if(n==1 || n==2) return fibo[n] = 1;
        else return fibo[n] = DFS(n-1)+DFS(n-2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        fibo = new int[n+1];
        DFS(n);
        for(int i=1; i<=n; i++) System.out.print(fibo[i]+" ");
    }
}
