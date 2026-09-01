import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
 static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    static boolean[][] visited;

    public int solution(int[][] land) {
        visited = new boolean[land.length][land[0].length];
        // 각 열에서 얻을 수 있는 석유량
        int[] oilByColumn = new int[land[0].length];
        
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    BFS(i, j, land, oilByColumn);
                }
            }
        }

        int answer = 0;
        for (int oil : oilByColumn) {
            answer = Math.max(answer, oil);
        }
        return answer;
    }

    public void BFS(int startX,int startY,int[][] land,int[] oilByColumn){
        Queue<int[]> Q = new LinkedList<>();
        Set<Integer> columns = new HashSet<>();

        int oilCount = 0;

        Q.offer(new int[]{startX,startY});
        visited[startX][startY] = true;

        while (!Q.isEmpty()){
            int[] poll = Q.poll();
            int x = poll[0];
            int y = poll[1];

            oilCount++;
            columns.add(y);
            
            for (int[] dis : dir){
                int nextX = x + dis[0];
                int nextY = y + dis[1];
                if(nextX < 0 || nextX >= land.length || nextY < 0 || nextY >= land[0].length) continue;
                if(land[nextX][nextY] == 1 && !visited[nextX][nextY]){
                    visited[nextX][nextY] = true;
                    Q.offer(new int[]{nextX,nextY});
                }
            }
        }
        for (int column : columns){
            oilByColumn[column] += oilCount;
        }
    }
}