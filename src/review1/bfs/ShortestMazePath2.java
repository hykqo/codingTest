package review1.bfs;

import java.util.LinkedList;
import java.util.Queue;
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
public class ShortestMazePath2 {

    static class XY {
        int x,y;

        public XY(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] grid = new int[7][7];
    static int[][] checkGrid = new int[7][7];
    static int[][] distance = new int[7][7];
    static int[][] dir = {{-1,0},{0,-1},{1,0},{0,1}};
    static Queue<XY> Q = new LinkedList<>();

    public static void BFS(int startX, int startY){
        XY start = new XY(startX, startY);
        Q.offer(start);
        checkGrid[startX][startY] = 1;
        distance[startX][startY] = 0;
        while (!Q.isEmpty()){
            XY poll = Q.poll();
            for (int[] dis : dir){
                int nextX = poll.x + dis[0];
                int nextY = poll.y + dis[1];
                if(nextX < 0 || nextX > 6 || nextY < 0 || nextY > 6) continue;

                if(grid[nextX][nextY] != 1 && checkGrid[nextX][nextY] == 0){
                    checkGrid[nextX][nextY] = 1;
                    distance[nextX][nextY] = distance[poll.x][poll.y]+1;
//                    if(nextX == 6 && nextY == 6) {
//                        System.out.println(distance[nextX][nextY]);
//                        Q.clear();
//                    } else{
                        Q.offer(new XY(nextX,nextY));
//                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for(int i=0; i<7; i++){
            for(int j=0; j<7; j++){
                grid[i][j] = scanner.nextInt();
            }
        }
        BFS(0,0);
    }
}
