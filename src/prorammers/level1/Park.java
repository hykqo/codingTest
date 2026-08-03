package prorammers.level1;

import java.util.*;

/*
3
5 3 2
8 6
A   A   -1  B   B   B   B   -1
A   A   -1  B   B   B   B   -1
-1  -1  -1  -1  -1  -1  -1  -1
D   D   -1  -1  -1  -1  E   -1
D   D   -1  -1  -1  -1  -1  F
D   D   -1  -1  -1  -1  -1  F
*/
public class Park {
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] mats = new int[n];
        for (int i=0; i<n; i++) mats[i] = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        String[][] park = new String[x][y];
        for (int i=0; i<x; i++) {
            for (int j=0; j<y; j++) {
                park[i][j] = scanner.next();
            }
        }
        System.out.println(solution(mats, park));
    }
}
