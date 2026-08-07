import java.util.Arrays;
import java.util.List;


class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        String[] s = {"code","date","maximum","remain"};
        List<String> columnList = Arrays.asList(s);
        int columnIdx = columnList.indexOf(ext);
        int sortIdx = columnList.indexOf(sort_by);
        return Arrays.stream(data).filter(d -> d[columnIdx] < val_ext)
                .sorted((d1,d2) -> d1[sortIdx] - d2[sortIdx]).toArray(int[][]::new);
    }
}