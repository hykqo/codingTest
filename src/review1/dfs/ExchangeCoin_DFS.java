package review1.dfs;

import java.util.*;

//ㅇ러 단위의 동전들이 있을때 거스름돈을 가장 적은 수의 동전으로 교환해주려면 어떻게 주면 되는가? (각 단위의 동전은 무한정 쓸 수 있음)
/*
3
1 2 5
15
*/
public class ExchangeCoin_DFS {
    static int n,m;
    static Integer[] kind;
    static int answer = Integer.MAX_VALUE;
    public static void DFS(int level, int sum){
        if(sum>m) return;
        if(level>=answer) return;
        if(sum==m) {
            answer = Math.min(answer, level);
        }else {
            for(int i=0; i<n; i++){
                DFS(level+1, sum+kind[i]);
            }
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt(); //동전의 종류개수
        kind = new Integer[n];
        for(int i=0; i<n; i++){
            kind[i] = scanner.nextInt();
        }
        Arrays.sort(kind, Collections.reverseOrder());

        m = scanner.nextInt(); //잔돈


        //거슬러 줄 동전의 최소 개수
        DFS(0,0);
        System.out.println(answer);

    }

}
