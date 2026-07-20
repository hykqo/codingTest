package review1.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
* 크루스칼 문제. 크루스칼은 union Find를 사용해야 함.
* 트리형식의 문제일 경우 사용해야 함. 모든 정점들을 가장 적은 비용으로 연결하기 위해 사용
* 트리형식에서는 간선은 정점-1임.
*
9 12

1 2 12
1 9 25
2 3 10
2 8 17
2 9 8
3 4 18
3 7 55
4 5 44
5 6 60
5 7 38
7 8 35
8 9 15

* */
public class wonderRandKruskalUnionFind2 {
    static int V, E;
    static int[] unf;

    static class Edge implements Comparable<Edge>{
        int v1, v2, cost;

        Edge(int v1, int v2, int cost){
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    static int find(int v){
        if(unf[v] == v) return v;
        else return unf[v] = find(unf[v]);
    }

    static void union(int a, int b){
        int fa = find(a);
        int fb = find(b);
        if(fa != fb) {
            unf[fa] = fb;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        V = scanner.nextInt();
        E = scanner.nextInt();
        unf = new int[V+1];
        List<Edge> edges = new ArrayList<>();

        for(int i=1; i<=V; i++){
            unf[i] = i;
        }

        for(int i=0; i<E; i++){
            int v1 = scanner.nextInt();
            int v2 = scanner.nextInt();
            int cost = scanner.nextInt();
            edges.add(new Edge(v1, v2, cost));
        }
        Collections.sort(edges);

        int res=0;
        for (Edge edge : edges){
            int v1 = edge.v1;
            int v2 = edge.v2;
            int cost = edge.cost;
            int fa = find(v1);
            int fb = find(v2);
            if(fa != fb){
                union(v1, v2);
                res += cost;
            }
        }
        System.out.println(res);
    }

}
