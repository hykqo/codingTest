import java.util.LinkedList;
import java.util.Queue;


class Solution {
static int[][] dis = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    public static int solution(String[] maps) {
        int[] startCoord = new int[2];
        int[] leverCoord = new int[2];
        int[] exitCoord = new int[2];

        String[][] map = new String[maps.length][maps[0].length()];
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {

                map[i][j] = String.valueOf(maps[i].charAt(j));

                if (map[i][j].equals("S")) {
                    startCoord[0] = i;
                    startCoord[1] = j;
                }

                if (map[i][j].equals("L")) {
                    leverCoord[0] = i;
                    leverCoord[1] = j;
                }

                if (map[i][j].equals("E")) {
                    exitCoord[0] = i;
                    exitCoord[1] = j;
                }
            }
        }

        // 1. 시작점 -> 레버
        int startToLever = BFS(startCoord, leverCoord, map);

        if (startToLever == -1) {
            return -1;
        }

        // 2. 레버 -> 출구
        int leverToExit = BFS(leverCoord, exitCoord, map);

        if (leverToExit == -1) {
            return -1;
        }


        return startToLever + leverToExit;
    }

    public static int BFS(int[] startCoord, int[] targetCoord, String[][] map){
        Queue<int[]> queue = new LinkedList<>();
        int[][] distance = new int[map.length][map[0].length];
        queue.add(startCoord);
        // 시작점을 1로 표시
        distance[startCoord[0]][startCoord[1]] = 1;

        while (!queue.isEmpty()){
            // 현재 탐색할 좌표를 Queue에서 꺼낸다.
            int[] currentCoord = queue.poll();
            // 목적지에 도착했다면
            if (currentCoord[0] == targetCoord[0] && currentCoord[1] == targetCoord[1]) {
                return distance[currentCoord[0]][currentCoord[1]] - 1; // 시작점이 1부터 시작했으므로 -1
            }

            for (int[] d : dis){
                int[] nextCoord = {currentCoord[0] + d[0], currentCoord[1] + d[1]};
                // 지도 범위를 벗어나면
                if (nextCoord[0] < 0 || nextCoord[0] >= map.length || nextCoord[1] < 0 || nextCoord[1] >= map[0].length) continue;
                // 벽이면
                if (map[nextCoord[0]][nextCoord[1]].equals("X")) continue;
                // 이미 방문했다면
                if (distance[nextCoord[0]][nextCoord[1]] != 0) continue;
                // 이동이 가능하다면 이동할 거리에 걸음수+1
                distance[nextCoord[0]][nextCoord[1]] = distance[currentCoord[0]][currentCoord[1]] + 1;
                queue.add(nextCoord);
            }
        }
        //목적지까지 갈 수 없음.
        return -1;
    }
}