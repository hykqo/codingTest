package prorammers.level1;

import java.util.ArrayList;
import java.util.List;

public class skillCheck2 {

    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] searched = search(data, ext, val_ext);
        sort(searched, sort_by);
        return searched;
    }

    public int[][] search(int[][] data, String ext, int val_ext){
        List<int[]> res = new ArrayList<>();
        int x = getIdx(ext);
        for (int i=0; i<data.length; i++){
            if(val_ext > data[i][x]){
                res.add(data[i]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public void sort(int[][] data, String sort_by){
        int[][] res = {};
        int x = getIdx(sort_by);
        for (int i=0; i<data.length; i++){
            for (int j=i+1; j<data.length; j++){
                if(data[i][x] > data[j][x]){
                    int[] tmp = data[i];
                    data[i] = data[j];
                    data[j] = tmp;
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
