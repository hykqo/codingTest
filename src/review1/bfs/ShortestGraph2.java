package review1.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
6 9
1 3
1 4
2 1
2 5
3 4
4 5
4 6
6 2
6 5
 * */
public class ShortestGraph2 {
    static int n, m;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch, dis;

    public static void BFS(int v){
        Queue<Integer> q = new LinkedList<>();
        ch[v]=1;
        dis[v]=0;
        q.offer(v);
        while(!q.isEmpty()){
            int now = q.poll();
            for(int next : graph.get(now)){
                if(ch[next] == 0){
                    ch[next]=1;
                    dis[next] = dis[now]+1;
                    q.offer(next);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        graph = new ArrayList<>();
        dis = new int[n+1];
        ch = new int[n+1];
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<m; i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            graph.get(a).add(b);
        }
        BFS(1);
        for(int i=2; i<=n; i++){
            System.out.println(i + " : " + dis[i]);
        }
    }
}
