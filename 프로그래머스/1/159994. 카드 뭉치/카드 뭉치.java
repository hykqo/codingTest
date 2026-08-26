import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
 public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> cardQ1 = new LinkedList<>(Arrays.asList(cards1));
        Queue<String> cardQ2 = new LinkedList<>(Arrays.asList(cards2));

        String answer = "Yes";
        for (String g : goal) {
            String peek1 = cardQ1.peek();
            String peek2 = cardQ2.peek();
            if (g.equals(peek1)) {
                cardQ1.poll();
            }else if(g.equals(peek2)) {
                cardQ2.poll();
            }else {
                answer = "No";
                break;
            }
        }
        return answer;
    }
}