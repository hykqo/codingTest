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
public class RoutsPlanning_DFSList {
    static int n, m, answer;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch;
    public void DFS(int v){
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
        RoutsPlanning_DFSList main = new RoutsPlanning_DFSList();
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        ch = new int[n+1];
        graph = new ArrayList<>();
        for(int i=0; i<=n; i++){ //1번 인덱스 부터 사용할거기 때문에 0~n까지 만들어져야 함.
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++){
            int index = scanner.nextInt();
            int value = scanner.nextInt();
            graph.get(index).add(value);
        }

        ch[1]=1;
        main.DFS(1);
        System.out.println(answer);
    }
}
