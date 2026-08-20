import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


class Solution {
        public int[] solution(String[] name, int[] yearning, String[][] photo) {
        List<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i=0; i<name.length; i++){
            int yearningScore = 0;
            if(yearning.length > i){
                yearningScore = yearning[i];
            }
            map.put(name[i], yearningScore);
        }

        for (int i=0; i<photo.length; i++){
            int totalScore = 0;
            for (int j=0; j<photo[i].length; j++){
                totalScore += map.getOrDefault(photo[i][j], 0);
            }
            answer.add(totalScore);
        }

        int[] result = new int[answer.size()];
        result = answer.stream().mapToInt(i->i).toArray();

        return result;
    }
}