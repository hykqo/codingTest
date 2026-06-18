package review1.dfs;

import java.util.Scanner;
/*
0 0 0 0 0 0 0
0 1 1 1 1 1 0
0 0 0 1 0 0 0
1 1 0 1 0 1 1
1 1 0 0 0 0 1
1 1 0 1 1 0 0
1 0 0 0 0 0 0
*/
public class GridMazeSolving {
    static int[][] grid;
    static int[][] checkGrid;
    static int[][] dir = {{-1,0},{0,-1},{1,0},{0,1}};

    static int count = 0;
    static void DFS(int x, int y){
        if(grid[x][y] == 1) return;
        if(x==6 && y == 6){
            count++;
        }else{
            for(int[] d : dir){
                int nextX = x+d[0];
                int nextY = y+d[1];
                if(nextX < 0 || nextX > 6 || nextY < 0 || nextY > 6) continue;
                if(checkGrid[nextX][nextY] != 1){
                    checkGrid[nextX][nextY] = 1;
                    DFS(nextX, nextY);
                    checkGrid[nextX][nextY] = 0;
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        grid = new int[7][7];
        checkGrid = new int[7][7];
        for (int i=0; i<7; i++){
            for (int j=0; j<7; j++){
                grid[i][j] = scanner.nextInt();
            }
        }
        checkGrid[0][0] = 1;
        DFS(0, 0);
        System.out.println(count);
    }
}
