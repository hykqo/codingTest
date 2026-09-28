package prorammers.level2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MonotonicStatck {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i=0; i< numbers.length; i++){
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]){
                int idx = stack.pop();
                answer[idx] = numbers[i];
            }
            stack.push(i);
        }

        return answer;
    }
    public static void main(String[] args) {
        MonotonicStatck ms = new MonotonicStatck();
        int[] numbers = {2, 3, 3, 5};
        int[] result = ms.solution(numbers);

        int[] numbers2 = {9, 1, 5, 3, 6, 2};
        int[] result2 = ms.solution(numbers2);

        for (int res : result) {
            System.out.println(res);
        }
        System.out.println("==================");
        for (int res : result2) {
            System.out.println(res);
        }
    }
}
