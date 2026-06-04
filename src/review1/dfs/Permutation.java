package review1.dfs;

import java.util.Scanner;

public class Permutation {
    static int n, m;
    static int[] pm, ch, arr;

    public static void DFS(int idx){
        if(idx==m){
            for(int x : pm) System.out.print(x+" ");
            System.out.println();
        }
        else {
            for(int i=0; i<n; i++){
                if(ch[i]==0){
                    pm[idx] = arr[i];
                    ch[i] = 1;
                    DFS(idx+1);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt(); //3
        m = scanner.nextInt(); //2
        arr = new int[n];
        for (int i=0; i<n; i++) arr[i] = scanner.nextInt(); //3 6 9
        ch= new int[n];
        pm= new int[m];
        DFS(0);

    }


}
