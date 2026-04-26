package review1.dfs;

/**
5 9
1 2
1 3
1 4
2 1
2 3
2 5
3 4
4 2
4 5
 * */

import java.util.ArrayList;
import java.util.Scanner;

//정점이 많으면 많을수록 인접행열로 처리하면 안되고 인접리스트로 처리해야 함,
public class RoutsPlanning_DFSList2 {
    static int n, m, answer;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch; //체크된 숫자.

    public static void DFS(int v){
        if(v==n) answer++;
        else {
            for(int nv : graph.get(v)){
                if(ch[nv] == 0) {
                    ch[nv] = 1;
                    DFS(nv);
                    ch[nv] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        ch = new int[n+1];
        graph = new ArrayList<>();
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<m; i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            graph.get(a).add(b);
        }
        ch[1] = 1;
        DFS(1);
        System.out.println(answer);
    }
}
