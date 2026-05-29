package review1.dfs;

import java.util.Scanner;

public class BadugiRide {
    static int c, n;
    static int[] w;
    static int max = Integer.MIN_VALUE;
    //c : 최대 탑승 킬로그램
    //n : 바둑이 마리수
    //w : 각 바둑이들의 무게

    //트럭에 태울 수 있는 가장 무거운 무게를 구해야 함. DFS로 풀어야 함.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        c = sc.nextInt(); //259
        n = sc.nextInt(); //5
        w = new int[n]; //[81,58,42,33,61]
        for(int i=0; i<n; i++) w[i] = sc.nextInt();
        DFS(0, 0);
        System.out.println(max);
    }

    public static void DFS(int idx, int sum){
        if(sum > c) return;
        if(idx == n) { //부분집합을 체크하는거기 때문에 종단노드 값만 구해야함.
            max = Math.max(max, sum);
        }else{
            DFS(idx+1, sum + w[idx]);
            DFS(idx+1, sum);
        }
    }
}
