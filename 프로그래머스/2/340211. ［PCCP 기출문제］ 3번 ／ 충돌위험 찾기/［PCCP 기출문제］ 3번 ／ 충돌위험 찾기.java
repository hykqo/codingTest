import java.util.*;
class Solution {
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