import java.util.ArrayList;
import java.util.List;


class Solution {
public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = {};
        int[][] search = search(data, ext, val_ext);
        sort(search, sort_by);
        return search;
    }

    public int[][] search(int[][] data, String ext, int val_ext){
        List<int[]> answer = new ArrayList<>();
        int idx = getIdx(ext);
        if(idx == -1) return null;
        for (int i=0; i<data.length; i++){
            if(data[i][idx] < val_ext){
                answer.add(data[i]);
            }
        }
        return answer.toArray(new int[answer.size()][]);
    }


    public void sort(int[][] data, String sort_by){
        int idx = getIdx(sort_by);
        if(idx == -1) return;
        for(int i=0; i<data.length; i++){
            for(int j=i+1; j<data.length; j++){
                if(data[i][idx] > data[j][idx]){
                    int[] tmp = data[j];
                    data[j] = data[i];
                    data[i] = tmp;
                }
            }
        }
    }

    public int getIdx(String by){
        if("code".equals(by)){
            return 0;
        }else if("date".equals(by)) {
            return 1;
        }else if("maximum".equals(by)) {
            return 2;
        }else if("remain".equals(by)) {
            return 3;
        } else return -1;
    }
}