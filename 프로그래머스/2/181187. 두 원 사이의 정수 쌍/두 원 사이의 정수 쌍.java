class Solution {
 public long solution(int r1, int r2) {
        long answer = 0;
        for (long x = 1; x <= r2; x++) {
            // 큰 원 안쪽에 들어오는 최대 y
            long maxY = (long) Math.floor(Math.sqrt((long) r2 * r2 - x * x));
            
            // 작은 원 바깥쪽에 들어오기 위한 최소 y
            long minY;
            if (x < r1) minY = (long) Math.ceil(Math.sqrt((long) r1 * r1 - x * x));
            else minY = 0;
            
            answer += maxY - minY + 1;
        }
        return answer * 4;
    }
}