package review1.dfs;

import java.util.Scanner;
/*
7
1 1 0 0 0 1 0
0 1 1 0 1 1 0
0 1 0 0 0 0 0
0 0 0 1 0 1 1
1 1 0 1 1 0 0
1 0 0 0 1 0 0
1 0 1 0 1 0 0
* */
public class Ireland {
    static int[][] grid;
    static int[][] dir = {{-1,0},{-1,-1},{0,-1},{1,-1},{1,0},{1,1},{0,1},{-1,1}}; //대각선까지
    static int count = 0;
    static int n;

    static void DFS(int x, int y){
        for (int[] d : dir){
            int nextX = x+d[0];
            int nextY = y+d[1];
            if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= n) continue;
            if(grid[nextX][nextY] == 1){
                grid[nextX][nextY] = 0;
                DFS(nextX, nextY);
            }
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        grid = new int[n][n];

        for(int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                grid[i][j] = scanner.nextInt();
            }
        }

        for(int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                if(grid[i][j]==1){
                    count++;
                    grid[i][j] = 0;
                    DFS(i,j);
                }
            }
        }
        System.out.println(count);
    }
}
