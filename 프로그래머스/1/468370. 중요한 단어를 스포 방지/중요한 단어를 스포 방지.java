import java.util.*;
class Solution {
    
    static class WordInfo {
        String word;
        int start;
        int end;
        int revealRange;

        WordInfo(String word, int start, int end, int revealRange) {
            this.word = word;
            this.start = start;
            this.end = end;
            this.revealRange = revealRange;
        }
    }

    public static int solution(String message, int[][] spoilerRanges) {
        int messageLength = message.length();
        int rangeCount = spoilerRanges.length;

        /*
         * 각 문자가 몇 번째 스포 방지 구간에 포함되는지 기록합니다.
         * 스포 구간이 아니면 -1입니다.
         */
        int[] spoilerRangeIndex = new int[messageLength];
        Arrays.fill(spoilerRangeIndex, -1);

        for (int rangeIndex = 0; rangeIndex < rangeCount; rangeIndex++) {
            int start = spoilerRanges[rangeIndex][0];
            int end = spoilerRanges[rangeIndex][1];

            for (int i = start; i <= end; i++) {
                spoilerRangeIndex[i] = rangeIndex;
            }
        }

        /*
         * revealWords.get(i):
         * i번째 스포 방지 구간을 클릭했을 때 완전히 공개되는 단어들
         */
        List<List<WordInfo>> revealWords = new ArrayList<>();

        for (int i = 0; i < rangeCount; i++) {
            revealWords.add(new ArrayList<>());
        }

        Set<String> normalWords = new HashSet<>();

        int index = 0;

        while (index < messageLength) {
            if (message.charAt(index) == ' ') {
                index++;
                continue;
            }

            int wordStart = index;

            while (index < messageLength && message.charAt(index) != ' ') {
                index++;
            }

            int wordEnd = index - 1;
            String word = message.substring(wordStart, wordEnd + 1);

            int revealRange = -1;

            /*
             * 단어에 포함된 문자 중 가장 나중 스포 구간을 찾습니다.
             * 해당 구간을 클릭해야 단어 전체가 공개됩니다.
             */
            for (int i = wordStart; i <= wordEnd; i++) {
                revealRange = Math.max(
                        revealRange,
                        spoilerRangeIndex[i]
                );
            }

            if (revealRange == -1) {
                // 스포 구간과 전혀 겹치지 않는 일반 단어
                normalWords.add(word);
            } else {
                revealWords.get(revealRange).add(
                        new WordInfo(
                                word,
                                wordStart,
                                wordEnd,
                                revealRange
                        )
                );
            }
        }

        Set<String> previouslyRevealedWords = new HashSet<>();
        int answer = 0;

        /*
         * 스포 구간을 클릭 순서대로 처리합니다.
         */
        for (int rangeIndex = 0; rangeIndex < rangeCount; rangeIndex++) {
            /*
             * 단어를 메시지의 왼쪽부터 읽어 저장했기 때문에
             * 같은 시점에 공개되는 단어도 왼쪽부터 처리됩니다.
             */
            for (WordInfo wordInfo : revealWords.get(rangeIndex)) {
                String word = wordInfo.word;

                boolean appearedInNormalArea =
                        normalWords.contains(word);

                boolean alreadyRevealed =
                        previouslyRevealedWords.contains(word);

                if (!appearedInNormalArea && !alreadyRevealed) {
                    answer++;
                }

                /*
                 * 중요한 단어가 아니더라도 공개된 스포 단어이므로
                 * 이후 중복 판단을 위해 반드시 저장합니다.
                 */
                previouslyRevealedWords.add(word);
            }
        }

        return answer;
    }
}