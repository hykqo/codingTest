package prorammers.level2;

import java.util.LinkedList;
import java.util.Queue;

/*
1 x 1 크기의 칸들로 이루어진 직사각형 격자 형태의 미로에서 탈출하려고 합니다. 각 칸은 통로 또는 벽으로 구성되어 있으며, 벽으로 된 칸은 지나갈 수 없고 통로로 된 칸으로만 이동할 수 있습니다.
통로들 중 한 칸에는 미로를 빠져나가는 문이 있는데, 이 문은 레버를 당겨서만 열 수 있습니다.
레버 또한 통로들 중 한 칸에 있습니다.
따라서, 출발 지점에서 먼저 레버가 있는 칸으로 이동하여 레버를 당긴 후 미로를 빠져나가는 문이 있는 칸으로 이동하면 됩니다.
이때 아직 레버를 당기지 않았더라도 출구가 있는 칸을 지나갈 수 있습니다.
미로에서 한 칸을 이동하는데 1초가 걸린다고 할 때, 최대한 빠르게 미로를 빠져나가는데 걸리는 시간을 구하려 합니다.

미로를 나타낸 문자열 배열 maps가 매개변수로 주어질 때, 미로를 탈출하는데 필요한 최소 시간을 return 하는 solution 함수를 완성해주세요.
만약, 탈출할 수 없다면 -1을 return 해주세요.


5 ≤ maps의 길이 ≤ 100
5 ≤ maps[i]의 길이 ≤ 100
maps[i]는 다음 5개의 문자들로만 이루어져 있습니다.
S : 시작 지점
E : 출구
L : 레버
O : 통로
X : 벽
시작 지점과 출구, 레버는 항상 다른 곳에 존재하며 한 개씩만 존재합니다.
출구는 레버가 당겨지지 않아도 지나갈 수 있으며, 모든 통로, 출구, 레버, 시작점은 여러 번 지나갈 수 있습니다.
* */
public class MazeEscape {
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


    public static void main(String[] args) {
        String[] maps1 = {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"};
        String[] maps2 = {"LOOXS","OOOOX","OOOOO","OOOOO","EOOOO"};

        System.out.println(new MazeEscape().solution(maps1));
        System.out.println(new MazeEscape().solution(maps2));
    }
}
