package review1.dfs;

import java.util.Scanner;

public class Olympiad {
    static int n;
    static int m;
    static int[] scoreArr;
    static int[] timeArr;
    static int maxScore = 0;

    public static void DFS(int idx, int sumTime, int sumScore){
        if(sumTime > m) return;
        if(idx == n) {
            if(m >= sumTime && sumScore > maxScore) maxScore = sumScore;
        }else{
            DFS(idx+1, sumTime+timeArr[idx], sumScore+scoreArr[idx]);
            DFS(idx+1, sumTime, sumScore);
        }
    }

    public static void main(String[] args) {
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
        DFS(0, 0, 0);
        System.out.println(maxScore);
    }
}
