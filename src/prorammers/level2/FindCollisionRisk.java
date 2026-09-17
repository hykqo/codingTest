package prorammers.level2;

import java.util.*;

/**
 n = (r,c)로 이루어진 2차원 좌표로 나타낼 수 있는 포인트의 갯수. 각 포인트는 1~n까지의 서로 다른 번호를 가짐.
 m = 로봇마다 정해진 운송 경로의 포인트의 갯수. 각 로봇은 첫 포인트부터 할당된 포인트를 순서대로 방문함.
 x = 운송시스템에서 사용되는 로봇의 갯수.
 r = 로봇이 1초마다 이동할 수 있는 좌표1.
 c = 로봇이 1초마다 이동할 수 있는 좌표2.

 로봇의 좌표는 1초마다 r 또는 c중 하나가 1만큼 감소하거나 증가한 좌표로 이동될 수 있음.
 로봇의 좌표는 항상 최단경로로 이동됨.
 로봇의 최단거리 이동경로가 여러가지일 경우, r좌표이동이  c좌표이동보다 우선시됨.

 answer = 로봇들이 같은 경로에 모여 충돌할 가능성이 있는 횟수.
* */

public class FindCollisionRisk {
    public int solution(int[][] points, int[][] routes) {
        // 각 로봇의 시간별 이동 좌표
        List<List<int[]>> robotPaths = new ArrayList<>();
        int maxTime = 0;

        // 1. 각 로봇의 이동 경로 생성
        for (int[] route : routes) {
            List<int[]> path = new ArrayList<>();
            int[] start = points[route[0] - 1];
            int r = start[0];
            int c = start[1];

            // 0초 위치
            path.add(new int[]{r, c});
            // 다음 포인트들을 순서대로 방문
            for (int i = 1; i < route.length; i++) {
                int[] target = points[route[i] - 1];
                int targetR = target[0];
                int targetC = target[1];

                // r 좌표를 먼저 이동
                while (r != targetR) {
                    if (r < targetR) r++;
                    else r--;
                    path.add(new int[]{r, c});
                }

                // 그 다음 c 좌표 이동
                while (c != targetC) {
                    if (c < targetC) c++;
                    else c--;
                    path.add(new int[]{r, c});
                }
            }
            robotPaths.add(path);
            maxTime = Math.max(maxTime, path.size());
        }

        // 2. 시간별 충돌 확인
        int answer = 0;
        for (int time = 0; time < maxTime; time++) {
            Map<String, Integer> positionCount = new HashMap<>();
            for (List<int[]> path : robotPaths) {
                // 이미 운송이 끝난 로봇
                if (time >= path.size()) continue;
                int[] position = path.get(time);
                String key = position[0] + "," + position[1];
                positionCount.put(key, positionCount.getOrDefault(key, 0) + 1);
            }

            // 같은 시간, 같은 좌표에 2대 이상 존재하면 위험상황 +1
            for (int count : positionCount.values()) {
                if (count >= 2) {
                    answer++;
                }
            }
        }
        return answer;
    }
}
