package review1.dfs;

import java.util.Scanner;

public class PermutationWithRepetition {
    static int n; //숫자 1부터 n까지
    static int m; //m개
    static int[] pm;
    public static void DFS(int L){
        if(L==m){
            for(int x : pm) System.out.print(x+" ");
            System.out.println();
        }else{
            for(int i=1; i<=n; i++){
                pm[L] = i;
                DFS(L+1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        pm = new int[m];
        DFS(0);
    }
}
