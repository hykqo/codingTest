package review1.dfs;

import java.util.Scanner;

public class fibonacci {
    static int[] fibo;
    public static int DFS(int n){
        if(n==1) return fibo[n] = 1;
        else if(n==2) return fibo[n] = 1;
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
