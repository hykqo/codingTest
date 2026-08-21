package review1.array;

import java.util.Map;

public class WalkPark {

    public static int[] solution(String[] park, String[] routes) {
        int[] lastCoord = new int[2];
        char[][] coord = new char[park.length][park[0].length()];
        for (int row = 0; row < park.length; row++) {
            for (int col = 0; col < park[0].length(); col++) {
                coord[row][col] = park[row].charAt(col);
                if (coord[row][col] == 'S') {
                    lastCoord = new int[]{row, col};
                }
            }
        }

        for (int i = 0; i < routes.length; i++) {
            String[] s = routes[i].split(" ");
            String direction = s[0];
            int route = Integer.parseInt(s[1]);
            int[] thisCoord = getNextCoord(lastCoord, direction, route);
            boolean check = check(coord, lastCoord, thisCoord);
            if(check) lastCoord = thisCoord;
        }
        return lastCoord;
    }

    static int[] getNextCoord(int[] befCoord, String direction, int route){
        int[] nextCoord = {befCoord[0], befCoord[1]};
        if ("N".equals(direction)) {
            nextCoord[0] -= route; // 행 감소
        } else if ("S".equals(direction)) {
            nextCoord[0] += route; // 행 증가
        } else if ("W".equals(direction)) {
            nextCoord[1] -= route; // 열 감소
        } else if ("E".equals(direction)) {
            nextCoord[1] += route; // 열 증가
        }
        return nextCoord;
    }

    static boolean check(char[][] coord, int[] befCord, int[] nextCord){
        if(befCord[0] == nextCord[0] && befCord[1] == nextCord[1]) return false;
        if(nextCord[0] < 0 || nextCord[0] >= coord.length) return false;
        if(nextCord[1] < 0 || nextCord[1] >= coord[0].length) return false;

        int startCord, endCord;
        if(befCord[0] != nextCord[0]){
            startCord = Math.min(befCord[0], nextCord[0]);
            endCord = Math.max(befCord[0], nextCord[0]);
            for (int i = startCord; i <= endCord; i++) {
                if(coord[i][befCord[1]] == 'X') return false;
            }
        } else {
            startCord = Math.min(befCord[1], nextCord[1]);
            endCord = Math.max(befCord[1], nextCord[1]);
            for (int i = startCord; i <= endCord; i++) {
                if(coord[befCord[0]][i] == 'X') return false;
            }
        }
        return true;
    }
}
