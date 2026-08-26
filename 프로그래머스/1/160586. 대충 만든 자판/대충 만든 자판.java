import java.util.HashMap;
class Solution {
 public static int[] solution(String[] keymap, String[] targets) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (String k : keymap) {
            for (int i=0; i<k.length(); i++) {
                char c = k.charAt(i);
                int thisTarget = i+1;
                map.putIfAbsent(c, thisTarget);
                int value = map.get(c);
                if (thisTarget < value) {
                    map.put(c, thisTarget);
                }
            }
        }

        int[] answer = new int[targets.length];
        for (int i = 0; i < targets.length; i++) {
            String t = targets[i];
            int cnt = 0;
            for (char c : t.toCharArray()) {
                if (!map.containsKey(c)){
                    cnt = -1;
                    break;
                }
                cnt += map.get(c);
            }
            answer[i] = cnt;
        }
        return answer;
    }
}