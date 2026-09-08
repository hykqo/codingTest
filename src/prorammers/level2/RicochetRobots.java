package prorammers.level2;

import java.util.*;

/*
리코쳇 로봇이라는 보드게임이 있습니다.
이 보드게임은 격자모양 게임판 위에서 말을 움직이는 게임으로, 시작 위치에서 출발한 뒤 목표 위치에 정확하게 멈추기 위해 최소 몇 번의 이동이 필요한지 말하는 게임입니다.
이 게임에서 말의 이동은 현재 위치에서 상, 하, 좌, 우 중 한 방향으로 게임판 위의 장애물이나 게임판 가장자리까지 부딪힐 때까지 미끄러져 움직이는 것을 한 번의 이동으로 정의합니다.
다음은 보드게임판을 나타낸 예시입니다. ("."은 빈 공간을, "R"은 로봇의 처음 위치를, "D"는 장애물의 위치를, "G"는 목표지점을 나타냅니다.)

게임판의 상태를 나타내는 문자열 배열 board가 주어졌을 때, 말이 목표위치에 도달하는데 최소 몇 번 이동해야 하는지 return 하는 solution함수를 완성해주세요. 만약 목표위치에 도달할 수 없다면 -1을 return 해주세요.
* */
public class RicochetRobots {

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

    public static void main(String[] args) {
        String[] board1 = {"...D..R",".D.G...","....D.D","D....D.","..D...."};
        String[] board2 = {".D.R", "....", ".G..", "...D"};
        System.out.println(new RicochetRobots().solution(board2));
        System.out.println(new RicochetRobots().solution(board1));
    }

}
