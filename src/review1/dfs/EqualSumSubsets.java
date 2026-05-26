package review1.dfs;

import java.util.Scanner;

public class EqualSumSubsets {
    static String answer = "NO";
    static int[] arr;
    static int n, total = 0;
    static boolean flag = false;
    public static void DFS(int L, int sum){
        if(flag) return;
        if(L == n) {
            if(total-sum == 0) answer = "YES";
            flag = true;
        }else {
            DFS(L+1, sum+arr[L]); //왼쪽 재귀 노드
            DFS(L+1, sum); //오른쪽 재귀 노드
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt(); // 6
        arr = new int[n]; // { 1, 3, 5, 6, 7, 10 }
        for(int i=0; i<n; i++){
            arr[i] = scanner.nextInt();
            total += arr[i];
        }
        DFS(0, 0);
        System.out.println(answer);
    }
}
