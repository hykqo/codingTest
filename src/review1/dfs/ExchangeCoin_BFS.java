package review1.dfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//ㅇ러 단위의 동전들이 있을때 거스름돈을 가장 적은 수의 동전으로 교환해주려면 어떻게 주면 되는가? (각 단위의 동전은 무한정 쓸 수 있음)
/*
3
1 2 5
15
*/
public class ExchangeCoin_BFS {
    static int n,m;
    static int level = 0;
    static int[] kind;
    static Queue<Integer> Q = new LinkedList<>();
    public static void BFS(){
        while (!Q.isEmpty()){
            level++;
            int len = Q.size();
            for (int i = 0; i < len; i++){
                Integer poll = Q.poll();
                if(poll == m) return;
                for(int j=0; j<n; j++){
                    Q.add(poll + kind[j]);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt(); //동전의 종류개수
        kind = new int[n];
        for(int i=0; i<n; i++){
            kind[i] = scanner.nextInt();
            Q.add(kind[i]);
        }
        m = scanner.nextInt(); //잔돈
        BFS();
        //거슬러 줄 동전의 최소 개수
        System.out.println(level);

    }

}
