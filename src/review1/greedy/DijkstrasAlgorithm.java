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
public class DijkstrasAlgorithm {
    static int n,m;
    static ArrayList<ArrayList<Edge>> graph;
    static int[] dis;

    static class Edge implements Comparable<Edge>{
        int vex; //정점
        int cost; //비용

        Edge(int vex, int cost) {
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
        n = scanner.nextInt();
        m = scanner.nextInt();
        graph = new ArrayList<>();
        for (int i=0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        dis = new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        for(int i=0; i<m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int cost = scanner.nextInt();
            graph.get(a).add(new Edge(b,cost));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(1,0)); //1번정점까지의 비용이 0이다 라는 뜻. 1-1까지의 거리는 구할필요가 없으므로 default셋팅.
        dis[1]=0;
        //다익스트라 알고리즘 실행.
        while (!pq.isEmpty()) {
            Edge tmp = pq.poll(); //priorityQueue가 compareTo함수를 이용해서 cost비용이 가장 작은 값을 poll해줌.
            int now = tmp.vex;
            int nowCost = tmp.cost;
            if(nowCost > dis[now]) continue;
            for(Edge ob : graph.get(now)) {
                if(dis[ob.vex] > nowCost + ob.cost) {
                    dis[ob.vex] = nowCost + ob.cost;
                    pq.offer(new Edge(ob.vex,dis[ob.vex]));
                }
            }
        }

        for(int i=2; i<=n; i++) {
            if(dis[i] == Integer.MAX_VALUE) {
                System.out.println( i+" : impossible");
            }else{
                System.out.println(i+" : "+dis[i]);
            }
        }
    }
}
