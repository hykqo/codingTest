import java.util.HashSet;


class Solution {
        public String solution(String s, String skip, int index) {

        HashSet<Character> skipSet = new HashSet<>();
        for (char c : skip.toCharArray()) skipSet.add(c);

        char[] answer = new char[s.length()];
        int charIdx = 0;
        for (Character c : s.toCharArray()){
            answer[charIdx] = getNextIndex(c, index, skipSet);
            charIdx++;
        }
        return String.valueOf(answer);
    }

    public char getNextIndex(char thisChar, int nextIdx, HashSet skip){
        char res = thisChar;
        int remainingCnt = nextIdx;
        while(remainingCnt > 0) {
            if(res == 'z') res = 'a';
            else res++;
            if (!skip.contains(res)) remainingCnt--;
        }
        return res;
    }
}