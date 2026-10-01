import java.util.LinkedList;
import java.util.Queue;


class Solution {
    public static class NumEntity {
        int baseNum;
        int depth;
        int n;
        int y;

        int nextNum;
        int nextNum2;
        int nextNum3;

        public NumEntity(int baseNum, int depth, int n, int y) {
            this.baseNum = baseNum;
            this.depth = depth;
            this.n = n;
            this.y = y;

            this.setNextNum();
        }

        private void setNextNum() {
            // ×2
            int next = this.baseNum * 2;
            if (next > this.y) {
                this.nextNum = -1;
            } else {
                this.nextNum = next;
            }

            // ×3
            int next2 = this.baseNum * 3;
            if (next2 > this.y) {
                this.nextNum2 = -1;
            } else {
                this.nextNum2 = next2;
            }

            // +n
            int next3 = this.baseNum + this.n;
            if (next3 > this.y) {
                this.nextNum3 = -1;
            } else {
                this.nextNum3 = next3;
            }
        }

        private boolean isEqualsY() {
            return nextNum == y
                    || nextNum2 == y
                    || nextNum3 == y;
        }

        private boolean isImpossible() {
            return nextNum == -1
                    && nextNum2 == -1
                    && nextNum3 == -1;
        }
    }


    public int solution(int x, int y, int n) {

        if (x == y) {
            return 0;
        }

        Queue<NumEntity> q = new LinkedList<>();
        boolean[] visited = new boolean[y + 1];
        q.offer(new NumEntity(x, 0, n, y));
        visited[x] = true;

        while (!q.isEmpty()) {
            NumEntity num = q.poll();
            if (num.isEqualsY()) return num.depth + 1;
            if (num.isImpossible()) continue;

            // ×2
            if (num.nextNum != -1 && !visited[num.nextNum]) {
                visited[num.nextNum] = true;
                q.offer(new NumEntity(num.nextNum,num.depth + 1,n,y));
            }
            // ×3
            if (num.nextNum2 != -1 && !visited[num.nextNum2]) {
                visited[num.nextNum2] = true;
                q.offer(new NumEntity(num.nextNum2,num.depth + 1,n,y));
            }
            // +n
            if (num.nextNum3 != -1 && !visited[num.nextNum3]) {
                visited[num.nextNum3] = true;
                q.offer(new NumEntity(num.nextNum3,num.depth + 1,n,y));
            }
        }

        return -1;
    }
}