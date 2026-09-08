import java.util.*;
class Solution {
public int solution(String[] board) {
        int rows = board.length;
        int cols = board[0].length();

        int startRow = 0;
        int startCol = 0;
        for (int i=0; i<board.length; i++){
            for (int j=0; j<board[i].length(); j++){
                if(board[i].charAt(j) == 'R'){
                    startRow = i;
                    startCol = j;
                }
            }
        }

        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startRow, startCol, 0});
        visited[startRow][startCol] = true;

        int[][] dir = {
                {-1, 0}, // 위
                {1, 0},  // 아래
                {0, -1}, // 왼쪽
                {0, 1}   // 오른쪽
        };

        while (!queue.isEmpty()){
            int[] poll = queue.poll();

            int row = poll[0];
            int col = poll[1];
            int count = poll[2];
            // d방향으로 장애물/벽 직전까지 슬라이딩.
            for (int[] dis : dir){
                //최종 정지 지점을 구한다.
                int[] nextCoord = slide(row, col, dis[0], dis[1], board);
                //G이면 return count +1;
                if (board[nextCoord[0]].charAt(nextCoord[1]) == 'G'){
                    return count+1;
                }
                //방문하지 않는 정지 지점이면
                if(!visited[nextCoord[0]][nextCoord[1]]){
                    //visted 처리 후 queue에 추가.
                    visited[nextCoord[0]][nextCoord[1]] = true;
                    queue.offer(new int[]{nextCoord[0], nextCoord[1], count+1});
                }
            }
        }
        return -1;
    }

    private int[] slide(int row, int col, int dr, int dc, String[] board) {
        // 이동 처리
        int nextRow = row;
        int nextCol = col;
        while(true){
            int moveRow = nextRow + dr;
            int moveCol = nextCol + dc;
            //move된 결과가 보드 밖인가?
            if(moveRow < 0 || moveRow >= board.length || moveCol < 0 || moveCol >= board[0].length()) break;
            //move된 결과가 D인가?
            if(board[moveRow].charAt(moveCol) == 'D') break;
            //이동할 수 있다면.
            nextRow = moveRow;
            nextCol = moveCol;
        }

        return new int[]{nextRow, nextCol};
    }
}