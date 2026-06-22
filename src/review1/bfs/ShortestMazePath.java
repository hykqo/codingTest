package review1.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.WeakHashMap;

/*
0 0 0 0 0 0 0
0 1 1 1 1 1 0
0 0 0 1 0 0 0
1 1 0 1 0 1 1
1 1 0 0 0 0 1
1 1 0 1 1 0 0
1 0 0 0 0 0 0
*/
public class ShortestMazePath {

    static class XY{
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

    public static void BFS(){
        checkGrid[0][0] = 1;
        distance[0][0] = 0;
        Q.offer(new XY(0,0));

        while (!Q.isEmpty()){
            XY cur = Q.poll();
            int x = cur.x;
            int y = cur.y;

            for(int[] d : dir){
                int nextX = x+d[0];
                int nextY = y+d[1];

                if(nextX < 0 || nextX > 6 || nextY < 0 || nextY > 6) continue;

                if(grid[nextX][nextY] == 0 && checkGrid[nextX][nextY] == 0) {
                    checkGrid[nextX][nextY] = 1;
                    distance[nextX][nextY] = distance[x][y]+1;
                    Q.offer(new XY(nextX,nextY));
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


        BFS();

        if (checkGrid[6][6] == 1) {
            System.out.println(distance[6][6]);
        } else {
            System.out.println(-1);
        }
    }
}
