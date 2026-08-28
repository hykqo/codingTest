package prorammers.level2;

public class PuzzleGame {
    public int solution(int[] diffs, int[] times, long limit) {
        //level=숙련도
        //제한시간내에 퍼즐을 모두 해결하기 위한 숙련도의 최솟값을 구하는 문제.

        //1. 제한시간 안에 풀 수 있는 level 최대 수 구하기.
        int maxLevel = 1;
        int minLevel = 1;
        for (int diff : diffs) maxLevel = Math.max(maxLevel, diff);

        //2. 레벨을 반갈해서 최솟값을 점진적으로 구하기
        int possibleMinLevel = maxLevel;
        while (minLevel<=maxLevel){
            int thisLevel = (maxLevel + minLevel) / 2;
            //문제 전부 푸는데 걸린 시간 축정
            long thisLimitForLevel = getThisLimitForLevel(thisLevel, diffs, times);
            //thisLevel로 구한 thisLimitForLevel 한계 limit보다 작으면 제한시간안에 푼거임. 한계 범위 축소.
            if(thisLimitForLevel <= limit) {
                maxLevel = thisLevel - 1;
                possibleMinLevel = Math.min(possibleMinLevel, thisLevel);
            }
            //thisLevel로 구한 limitTime이 한계 limit보다 크면 제한시간 초과임. 풀수 없다는거니까 한계 범위 확대.
            else minLevel = thisLevel + 1;
        }
        return possibleMinLevel;
    }

    public long getThisLimitForLevel(int level, int[] diffs, int[] times){
        long accumulateTime = 0;
        for (int i=0; i<diffs.length; i++){
            if(diffs[i] <= level) accumulateTime += times[i];
            else {
                int timePrev = 0;
                if(i != 0) timePrev = times[i-1];
                accumulateTime += (long) (timePrev + times[i]) * (diffs[i] - level) + times[i];
            }
        }
        return accumulateTime;
    }

    public static void main(String[] args) {
        PuzzleGame gamer = new PuzzleGame();
//        int solution1 = gamer.solution(new int[]{1, 5, 3}, new int[]{2, 4, 7}, 30);
//        System.out.println(solution1);

//        int solution2 = gamer.solution(new int[]{1, 4, 4, 2}, new int[]{6, 3, 8, 2}, 59);
//        System.out.println(solution2);

//        int solution3 = gamer.solution(new int[]{1, 328, 467, 209, 54}, new int[]{2, 7, 1, 4, 3}, 1723);
//        System.out.println(solution3);

        int solution4 = gamer.solution(new int[]{1, 99999, 100000, 99995}, new int[]{9999, 9001, 9999, 9001}, 3456789012L);
        System.out.println(solution4);
    }
}
