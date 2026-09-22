package prorammers.level2;

import java.util.*;

public class PerfectCrime {
    public int solution(int[][] info, int n, int m) {
        Queue<int[]> queue = new ArrayDeque<>();
        Queue<int[]> nextQueue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});

        int depth = 0;
        while (!queue.isEmpty()){
            int[] thisSavagePnt = queue.poll();
            int[] nextSavagePnt = info[depth];

            //a훔침
            int nextAPnt = nextSavagePnt[0] + thisSavagePnt[0];
            if(nextAPnt < n) {
                nextQueue.offer(new int[]{nextAPnt, thisSavagePnt[1]});
            }
            //b훔침
            int nextBPnt = nextSavagePnt[1] + thisSavagePnt[1];
            if(nextBPnt < m) {
                nextQueue.offer(new int[]{thisSavagePnt[0], nextBPnt});
            }

            if (queue.isEmpty()) {
                depth++;
                if (depth == info.length) {
                    break;
                }
                queue = nextQueue;
                nextQueue = new LinkedList<>();
            }
        }

        int answer = Integer.MAX_VALUE;
        while (!nextQueue.isEmpty()) {
            int[] thisSavagePnt = nextQueue.poll();
            answer = Math.min(answer, thisSavagePnt[0]);
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    public static void main(String[] args) {
        PerfectCrime pc = new PerfectCrime();
        pc.solution(new int[][]{{1, 2}, {2, 3}, {2, 1}}, 4, 4);
    }
}
