package prorammers.level1;

import java.util.HashMap;

public class JoyKeyboard {
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


    public static void main(String[] args) {
        int[] res1 = solution(new String[]{"ABACD", "BCEFD"}, new String[]{"ABCD", "AABB"});
        int[] res2 = solution(new String[]{"AA"}, new String[]{"B"});
        int[] res3 = solution(new String[]{"AGZ", "BSSS"}, new String[]{"ASA", "BGZ"});
        System.out.println("1. " + res1[0] + " " + res1[1]);
        System.out.println("2. " + res2[0]);
        System.out.println("3. " + res3[0] + " " + res3[1]);
    }

}
