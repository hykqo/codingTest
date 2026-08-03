import java.util.*;

class Solution {
    public static int solution(int[] mats, String[][] park) {
        Arrays.sort(mats);
        for (int i=mats.length-1; i>=0; i--) {
            if(getAvailableMat(mats[i], park)) {
                return mats[i];
            }
        }
        return -1;
    }

    public static boolean getAvailableMat(int mat, String[][] park){
        int rows = park.length;
        int cols = park[0].length;

        //startX, starY를 돗자리의 왼쪽 위 좌표로 사용
        for (int startX=0; startX<=rows - mat; startX++){
            for (int starY=0; starY<=cols - mat; starY++){

                boolean isAllAvailable = true;

                //startX, startY부터 mat x mat 영역 검사
                for (int x=startX; x<startX + mat; x++){
                    for (int y=starY; y<starY + mat; y++){
                        if(!isAvailable(park, x, y)) {
                            isAllAvailable = false;
                            break;
                        }
                    }

                    if(!isAllAvailable) {
                        break;
                    }
                }

                if(isAllAvailable) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isAvailable(String park[][], int x, int y){
        return park[x][y].equals("-1");
    }
}