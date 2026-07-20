package review1.greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
* 프림 문제. Priority Queue를 사용해야 함.
* 트리형식의 문제일 경우 사용해야 함. 모든 정점들을 가장 적은 비용으로 연결하기 위해 사용
* 트리형식에서는 간선은 정점-1임.
* 프림 알고리즘은 기본적으로 무방향이므로 간선을 양방향으로 추가해야 함.

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
public class wonderRandPrimPriorityQueue2 {
    static int V,E;
    static int[] ch;

    public static class Edge implements Comparable<Edge>{
        int v, cost;

        Edge(int v, int cost){
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        V = scanner.nextInt();
        E = scanner.nextInt();
        ch = new int[V+1];
        List<List<Edge>> edges = new ArrayList<>();

        for(int i=0; i<=V; i++){
            edges.add(new ArrayList<>());
        }

        for(int i=0; i<E; i++){
            int v1 = scanner.nextInt();
            int v2 = scanner.nextInt();
            int cost = scanner.nextInt();
            edges.get(v1).add(new Edge(v2, cost));
            edges.get(v2).add(new Edge(v1, cost));
        }
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.add(new Edge(1, 0));
        int res = 0;
        while (!pQ.isEmpty()){
            Edge poll = pQ.poll();
            int endV = poll.v;
            if(ch[endV] != 1){
                ch[endV] = 1;
                for(Edge edge : edges.get(endV)){
                    if(ch[edge.v] != 1){
                        pQ.add(edge);
                    }
                }
                res += poll.cost;
            }
        }
        System.out.println(res);
    }

}
