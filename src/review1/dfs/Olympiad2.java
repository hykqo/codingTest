package review1.dfs;

import java.util.Scanner;

public class Olympiad2 {
    static int n;
    static int m;
    static int[] scoreArr;
    static int[] timeArr;
    static int maxScore = Integer.MIN_VALUE;

    public void DFS(int idx, int sumTime, int sumScore){
        if(sumTime > m) return;
        if(idx == n) {
            maxScore = Math.max(maxScore, sumScore);
        }else{
            DFS(idx+1, sumTime+timeArr[idx], sumScore+scoreArr[idx]);
            DFS(idx+1, sumTime, sumScore);
        }
    }

    public static void main(String[] args) {
        Olympiad2 T = new Olympiad2();
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt(); //문제개수 5
        m = scanner.nextInt(); //제한시간 20
        scoreArr = new int[n];
        timeArr = new int[n];
        for(int i=0; i<n; i++){
            scoreArr[i] = scanner.nextInt();    //  10 25 15 6 7
            timeArr[i] = scanner.nextInt();     //   5 12  8 3 4
        }

        //제한 시간안에 얻을 수 있는 최대 점수를 출력
        T.DFS(0, 0, 0);
        System.out.println(maxScore);
    }
}
