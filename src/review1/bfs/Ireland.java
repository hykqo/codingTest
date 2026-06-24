package review1.bfs;

import java.util.LinkedList;
import java.util.Queue;
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

    static class XY{
        int x,y;
        public XY(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] grid;
    static int[][] dir = {{-1,0},{-1,-1},{0,-1},{1,-1},{1,0},{1,1},{0,1},{-1,1}}; //대각선까지
    static Queue<XY> Q = new LinkedList<>();
    static int count = 0;
    static int n;

    static void BFS(){
        while (!Q.isEmpty()){
            XY poll = Q.poll();
            int x = poll.x;
            int y = poll.y;
            for(int[] dis : dir){
                int nextX = x+dis[0];
                int nextY = y+dis[1];
                if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= n) continue;
                if(grid[nextX][nextY] == 1){
                    grid[nextX][nextY] = 0;
                    Q.offer(new XY(nextX,nextY));
                }
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
                    Q.offer(new XY(i,j));
                    BFS();
                }
            }
        }
        System.out.println(count);
    }
}
