package review1.dfs;

import java.util.Scanner;

public class Permutation2 {
    static int n, m;
    static int[] pm, arr, ch;

    public static void DFS(int idx){
        if(idx==m){
            for(int x : pm) System.out.print(x+" ");
            System.out.println();
        }else{
            for(int i=0; i<n; i++){
                if(ch[i]==0){
                    pm[idx] = arr[i]; //기록
                    ch[i]=1;
                    DFS(idx+1);
                    ch[i]=0;
                }

            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        pm = new int[m];
        arr = new int[n];
        ch = new int[n];
        for(int i=0; i<n; i++) arr[i] = scanner.nextInt();
        DFS(0);
    }

}
