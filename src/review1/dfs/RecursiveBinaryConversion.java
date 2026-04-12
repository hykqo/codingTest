package review1.dfs;

import java.util.Scanner;

public class RecursiveBinaryConversion {
    public static void DFS(int n){
        if(n == 0) return;
        DFS(n/2);
        int x = n % 2;
        System.out.print(x);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        DFS(n);

    }
}
