package review1.greedy;

import java.util.*;

/*
* 다익스트라는 원래 n*o(n)이 아니라 n*log(n)으로 할수 있는 방법이 있음
* PriorityQueue를 사용하면 nLog(n)으로 가능함.
*
6 9
1 2 12
1 3 4
2 1 2
2 3 5
2 5 5
3 4 5
4 2 2
4 5 5
6 4 5
* *
* * */
public class DijkstrasAlgorithm2 {

    static class Edge implements Comparable<Edge>{
        int vex;
        int cost;

        Edge(int vex, int cost){
            this.vex = vex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] dis = new int[n+1];
        List<List<Edge>> edges = new ArrayList<>();
        for (int i=0; i<=n; i++){
            edges.add(new ArrayList<>());
            dis[i] = Integer.MAX_VALUE;
        }

        for(int i=0; i<m; i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            Edge edge = new Edge(b, c);
            edges.get(a).add(edge);
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(1, 0));
        dis[1] = 0;
        while (!pq.isEmpty()){
            Edge now = pq.poll();
            int thisIdx = now.vex;
            int befCost = now.cost;
            List<Edge> thisEdges = edges.get(thisIdx);
            for (Edge edge : thisEdges){
                int nextIdx = edge.vex;
                int nextCost = befCost + edge.cost;
                if(dis[nextIdx] > nextCost) {
                    dis[nextIdx] = nextCost;
                    pq.offer(new Edge(nextIdx, nextCost));
                }
            }
        }

        for(int i=2; i<=n; i++) {
            if(dis[i] == Integer.MAX_VALUE) System.out.println(i + " : impossible");
            else System.out.println(i + " : "+ dis[i]);
        }
    }
}
