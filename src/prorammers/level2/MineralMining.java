package prorammers.level2;

import java.util.ArrayList;
import java.util.List;

public class MineralMining {

    public class MineralGroup{
        int diamond =  0;
        int iron =  0;
        int stone =  0;

        private void refine(String mineral){
            if (mineral.equals("diamond")) {
                this.diamond += 1;
            }else if(mineral.equals("iron")){
                this.iron += 1;
            }else if(mineral.equals("stone")){
                this.stone += 1;
            }
        }

        private int getScore() {
            return diamond * 25
                    + iron * 5
                    + stone;
        }

        private int calculateFatigue(int pickType) {
            if (pickType == 0) {
                return diamond + iron + stone;
            } else if (pickType == 1) {
                return diamond * 5 + iron + stone;
            } else {
                return diamond * 25 + iron * 5 + stone;
            }
        }
    }

    public int solution(int[] picks, String[] minerals) {
        int pickCount = picks[0] + picks[1] + picks[2];
        int maxMineralCount = Math.min(pickCount * 5, minerals.length);
        //minerals를 5개 단위로 묶음 처리
        List<MineralGroup> mineralGroups = new ArrayList<>();
        int idx = 0;
        while (idx < maxMineralCount) {
            MineralGroup mineralGroup = new MineralGroup();
            int maxIdx = Math.min(idx + 5, maxMineralCount);
            for (int i = idx; i < maxIdx; i++) {
                mineralGroup.refine(minerals[i]);
            }
            mineralGroups.add(mineralGroup);
            idx = maxIdx;
        }
        //내림차순
        mineralGroups.sort((a,b)->b.getScore() - a.getScore());

        int answer = 0;
        for (MineralGroup mineralGroup : mineralGroups) {
            if (picks[0] > 0) {
                // 다이아 곡괭이 사용
                answer += mineralGroup.calculateFatigue(0);
                picks[0]--;
            } else if (picks[1] > 0) {
                // 철 곡괭이 사용
                answer += mineralGroup.calculateFatigue(1);
                picks[1]--;
            } else if (picks[2] > 0) {
                // 돌 곡괭이 사용
                answer += mineralGroup.calculateFatigue(2);
                picks[2]--;
            }
        }
        return answer;
    }

    public static void main(String[] args) {

        MineralMining m = new MineralMining();
        int[] picks = {1,3,2};
        String[] minerals = {"diamond","diamond","diamond","iron","iron","diamond","iron","stone"};
        System.out.println(m.solution(picks, minerals));

    }
}
