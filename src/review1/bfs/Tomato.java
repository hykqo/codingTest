package review1.bfs;

import java.util.*;
/*
6 4
0 0 -1 0 0 0
0 0 1 0 -1 0
0 0 -1 0 0 0
0 0 0 0 -1 1
* */
public class Tomato {

    static class XY{
        int x,y;
        public XY(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int n,m;
    static int[][] grid;
    static int[][] checkGrid;
    static int[][] dir = {{-1,0},{0,-1},{1,0},{0,1}};
    static int[][] distance; //익는데 걸리는 소요 날짜
    static Queue<XY> Q = new LinkedList<>();

    static int maxLevel = 0;
    public static void BFS(){
        while (!Q.isEmpty()) {
            XY poll = Q.poll();
            int x = poll.x;
            int y = poll.y;
            for(int[] dis : dir){
                int nextX = x+dis[0];
                int nextY = y+dis[1];
                if(nextX >= m || nextX < 0 || nextY >= n || nextY < 0) continue;
                if(grid[nextX][nextY]== 0 && checkGrid[nextX][nextY] == 0 && grid[nextX][nextY] != -1) {
                    checkGrid[nextX][nextY] = 1;
                    distance[nextX][nextY] = distance[x][y]+1;
                    maxLevel = Math.max(maxLevel, distance[nextX][nextY]);
                    Q.offer(new XY(nextX,nextY));
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        grid = new int[m][n];
        checkGrid = new int[m][n];
        distance = new int[m][n];
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                int k = scanner.nextInt();
                grid[i][j] = k;
                if(k == 1) {
                    XY xy = new XY(i, j);
                    Q.offer(xy);
                    distance[i][j] = 0;
                }
            }
        }

        BFS();
        System.out.println(maxLevel);
    }
}
