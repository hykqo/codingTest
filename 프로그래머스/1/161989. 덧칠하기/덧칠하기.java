class Solution {
    public static int solution(int n, int m, int[] section) {
        int answer = 0;
        // 현재까지 페인트가 칠해진 마지막 구역
        int paintedEnd = 0;
        for (int current : section) {
            // 현재 구역이 이미 칠해져 있다면 넘어감.
            if (current <= paintedEnd) continue;
            // 아직 안 칠해져 있다면 롤러 칠하기.
            answer++;
            // current부터 m칸을 칠하므로 마지막 구역은 current + m - 1
            paintedEnd = current + m - 1;
        }
        return answer;
    }
}