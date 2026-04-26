package review1.dfs;

import java.util.Scanner;
//인접행열은 정점이 많으면 많을수록 비효울적임.
//예를 들어 정점이 만개라면 2차원 배열을 만드는데만 10000 * 10000 = 100000000(1억)이 필요하고 o(n^2)이 되서 망함.
public class RoutePlanning_DFSMatrix {
    static int n, m, answer=0;
    static int[][] graph;
    static int[] ch;
    public static void DFS(int v){
        //현재 노드(v)가 n이라면? 갯수++
        if(v==n) answer++;
        else {
            for(int i=1; i<=n; i++){
                //간선이 존재하면서 방문한적이 없으면?
                if(graph[v][i] == 1 && ch[i] == 0) {
                    ch[i] = 1;
                    DFS(i);
                    ch[v] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //정점의 수 ex) 5
        n = scanner.nextInt();
        //간선의 수 ex) 9
        m = scanner.nextInt();
        graph = new int[n][m];
        for(int i=0; i<m; i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            graph[a][b] = 1;
        }
        ch[1]=1;
        DFS(1);
        System.out.println(answer);

    }
}
