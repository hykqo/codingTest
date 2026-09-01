package prorammers.level2;

import java.util.Arrays;

public class InterceptorSystem {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (a, b) -> Integer.compare(a[1], b[1]));
        int answer = 0;
        int lastEnd = -1;
        for (int[] target : targets) {
            int start = target[0];
            int end = target[1];
            if (start >= lastEnd) {
                answer++;
                lastEnd = end;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
       int [][] arr = {{4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}};
       System.out.println(new InterceptorSystem().solution(arr));
    }
}
