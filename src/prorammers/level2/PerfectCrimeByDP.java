package prorammers.level2;

import java.util.Arrays;

public class PerfectCrimeByDP {
    public static int solution(int[][] info, int n, int m) {

        final int INF = Integer.MAX_VALUE;

        // dp[b] = B 흔적이 b일 때 A 흔적의 최소값
        int[] dp = new int[m];
        Arrays.fill(dp, INF);

        dp[0] = 0;
        for (int[] item : info) {
            int aTrace = item[0];
            int bTrace = item[1];
            // 현재 물건 처리 결과
            int[] next = new int[m];
            Arrays.fill(next, INF);
            for (int b = 0; b < m; b++) {
                // 존재하지 않는 상태
                if (dp[b] == INF) {
                    continue;
                }
                /*
                 * A가 훔침
                 */
                int nextA = dp[b] + aTrace;
                if (nextA < n) {
                    next[b] = Math.min(next[b], nextA);
                }
                /*
                 * B가 훔침
                 */
                int nextB = b + bTrace;
                if (nextB < m) {
                    next[nextB] = Math.min(next[nextB], dp[b]);
                }
            }
            dp = next;
        }

        int answer = INF;

        for (int b = 0; b < m; b++) {
            answer = Math.min(answer, dp[b]);
        }
        return answer == INF ? -1 : answer;
    }

    public static void main(String[] args) {
        PerfectCrimeByDP pc = new PerfectCrimeByDP();
        pc.solution(new int[][]{{1, 2}, {2, 3}, {2, 1}}, 4, 4);
    }
}
