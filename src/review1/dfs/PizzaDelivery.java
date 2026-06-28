package review1.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/*
4 4
0 1 2 0
1 0 2 1
0 2 1 2
2 0 1 2
* */

//수식과 단순 for문사용. 각 거리 계산식 : |x1-x2| + |y1-y2| = 배달거리
public class PizzaDelivery {
    static int n,m;
    static int[][] grid;
    static int[][] dis;

    public static class XY{
        int x,y;

        public XY(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void DFS(int start, int detph){
        if(detph == m) {
            //선택 완료
            return;
        }

        for (int i=start; i<n; i++) {

        }

    }

    public int combi(int n, int r){
        if(grid[n][r]>0) return grid[n][r];
        if(n==r || r==0) return 1;
        else return grid[n][r] = combi(n-1, r-1) + combi(n-1, r);
    }

    public static int calcDistance(XY a, XY b){
        return Math.abs((a.x+1)-(b.x+1)) + Math.abs((a.y+1)-(b.y+1));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
    }
}
