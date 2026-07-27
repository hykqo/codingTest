package prorammers.level1;

import java.util.*;

/*
here is muzi here is a secret message
2
0 3
23 28
result = 1


my phone number is 01012345678 and may i have your phone number
4
5 5
25 28
34 40
53 59
result = 4

* */
public class SpoilerRanges {

    static class WordInfo {
        String word;
        int start;

        WordInfo(String word, int start) {
            this.word = word;
            this.start = start;
        }
    }

    public static int solution(String message, int[][] spoiler_ranges){
        int messageLength = message.length();
        int rangeCount = spoiler_ranges.length;

        /*
         * spoilerIndex[i]
         * - message의 i번째 문자가 어떤 스포 방지 구간에 포함되는지 저장
         * - 포함되지 않으면 -1
         * - 포함된다면 해당 spoilerRanges의 인덱스
         */
        int[] spoilerIndex = new int[messageLength];
        Arrays.fill(spoilerIndex, -1);
        for (int rangeIndex = 0; rangeIndex < rangeCount; rangeIndex++) {
            int start = spoiler_ranges[rangeIndex][0];
            int end = spoiler_ranges[rangeIndex][1];

            for (int i = start; i <= end; i++) {
                spoilerIndex[i] = rangeIndex;
            }
        }

        /*
         * revealWords[i]
         * i번째 스포 방지 구간을 클릭했을 때
         * 완전히 공개되는 단어들의 목록 초기화
         */
        List<List<WordInfo>> revealWords = new ArrayList<>();
        for (int i = 0; i < rangeCount; i++) {
            revealWords.add(new ArrayList<>());
        }

        /*
         * 스포 방지 구간이 전혀 적용되지 않은 상태로 등장한 단어
         *
         * 이 집합에 들어 있는 단어는 조건 2에 의해
         * 중요한 단어가 될 수 없습니다.
         */
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

            boolean isSpoilerWord = false;

            /*
             * 이 단어가 완전히 공개되는 스포 방지 구간 번호입니다.
             *
             * 여러 스포 방지 구간에 걸쳐 있다면
             * 가장 마지막 구간을 클릭해야 완전히 공개됩니다.
             */
            int revealRangeIndex = -1;

            for (int i = wordStart; i <= wordEnd; i++) {
                if (spoilerIndex[i] != -1) {
                    isSpoilerWord = true;
                    revealRangeIndex = Math.max(
                            revealRangeIndex,
                            spoilerIndex[i]
                    );
                }
            }

            if (isSpoilerWord) {
                revealWords
                        .get(revealRangeIndex)
                        .add(new WordInfo(word, wordStart));
            } else {
                normalWords.add(word);
            }
        }


        /*
         * 지금까지 완전히 공개된 모든 스포 방지 단어입니다.
         *
         * 중요한 단어뿐 아니라, 조건을 만족하지 못한 단어도
         * "이전에 공개된 스포 방지 단어"에 해당하므로 저장해야 합니다.
         */
        Set<String> revealedSpoilerWords = new HashSet<>();

        int answer = 0;

        for (int rangeIndex = 0; rangeIndex < rangeCount; rangeIndex++) {
            /*
             * 단어를 메시지에서 왼쪽부터 읽으면서 넣었기 때문에
             * revealWords 내부 순서도 왼쪽부터 정렬되어 있습니다.
             */
            for (WordInfo wordInfo : revealWords.get(rangeIndex)) {
                String word = wordInfo.word;

                boolean appearedInNormalArea = normalWords.contains(word);
                boolean alreadyRevealed = revealedSpoilerWords.contains(word);

                if (!appearedInNormalArea && !alreadyRevealed) {
                    answer++;
                }

                /*
                 * 중요 단어 여부와 관계없이,
                 * 이번 시점에 공개된 스포 방지 단어로 기록합니다.
                 */
                revealedSpoilerWords.add(word);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String message = sc.nextLine();
        int n = sc.nextInt();
        int[][] spoiler_ranges = new int[n][2];
        for(int i=0; i<n; i++){
            spoiler_ranges[i][0] = sc.nextInt();
            spoiler_ranges[i][1] = sc.nextInt();
        }
        System.out.println(solution(message, spoiler_ranges));
    }
}
