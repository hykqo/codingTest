import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
class Solution {
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
}