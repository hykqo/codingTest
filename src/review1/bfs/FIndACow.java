package review1.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FIndACow {
    int[] dis = {1, -1 , 5};
    int[] ch;
    Queue<Integer> Q = new LinkedList<>();

    public int BFS(int s, int e){
        ch = new int[10001];
        ch[s] = 1;
        Q.offer(s);
        int L = 0;
        while(!Q.isEmpty()){
            int len = Q.size();
            for(int i=0; i<len; i++){
                int target = Q.poll();
                for(int j=0; j<3; j++){
                   int nextTarget = target + dis[j];
                    if(nextTarget == e) return L+1;
                   //방문 안한곳
                   if(nextTarget >= 1 && nextTarget <= 10000 && ch[nextTarget] == 0) {
                       ch[nextTarget] = 1;
                       Q.offer(nextTarget);
                   }
                }
            }
            L++;
        }
        return L;
    }

    public static void main(String[] args) {
    //bfs로 탐색해볼거임.
    FIndACow F = new FIndACow();
    Scanner scanner = new Scanner(System.in);
    int S = scanner.nextInt(); //현수위치
    int E = scanner.nextInt(); //송아지 위치
    System.out.println(F.BFS(S,E));
    }
}
