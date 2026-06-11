package review1.dfs;

import java.util.Scanner;

/*
쉽게 배우는 알고리즘 문제풀이
수열 추측하기

가장 윗줄에 1부터 N까지의 숫자가 한 개씩 적혀 있다. 그리고 둘째 줄부터는 차례대로 파스칼의 삼각형처럼 위의 두 개를 더한 값이 저장된다.

예를 들어 N이 4이고 가장 윗줄에 3 1 2 4가 있다고 했을 때, 다음과 같은 삼각형이 그려진다.

    3 1 2 4
     4 3 6
      7 9
       16

N과 가장 밑에 있는 숫자가 주어졌을 때, 가장 윗줄에 있는 숫자를 구하는 프로그램을 작성하시오.

단, 답이 여러 가지인 경우에는 사전순으로 가장 앞에 오는 것을 출력해야 한다.

입력설명

첫째 줄에 두 개의 정수 N(1 ≤ N ≤ 10)과 F가 주어진다.

N은 가장 윗줄에 있는 숫자의 개수이다.
F는 가장 밑에 있는 숫자를 의미한다.
F는 1,000,000 이하의 자연수이다.
출력설명

첫째 줄에 삼각형의 가장 윗줄에 들어갈 N개의 숫자를 빈칸으로 구분하여 출력한다.

답이 존재하지 않는 경우는 입력으로 주어지지 않는다.

입력예제 1
4 16
출력예제 1
3 1 2 4

* */
public class NumberSequencesPuzzleSolution2 {
    static int n, f;
    static int[] weightValues, dfsCheckList, sequence;
    static int[][] cache = new int[10][10];
    static boolean flag = false;
    public int combi(int n, int r){
        if(cache[n][r] > 0) return cache[n][r];
        if(n == r || r == 0) return 1;
        else return cache[n][r] = combi(n-1, r-1) + combi(n-1, r);
    }

    public void DFS(int L, int sum){
        if(flag) return;
        if(L == n){
            if(sum == f){
                for (int x : sequence) System.out.print(x+" ");
                flag = true;
            }
        }else {
            for(int i=1; i<=n; i++){
                if(dfsCheckList[i] == 1) continue;
                dfsCheckList[i] = 1;
                sequence[L] = i;
                DFS(L+1, sum+(sequence[L]*weightValues[L]));
                dfsCheckList[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        NumberSequencesPuzzleSolution2 T = new NumberSequencesPuzzleSolution2();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        f = sc.nextInt();

        sequence = new int[n];
        dfsCheckList = new int[n+1];
        weightValues = new int[n];

        for(int i=0; i<n; i++) {
            weightValues[i] = T.combi(n-1, i);
        }
        T.DFS(0, 0);
    }
}
