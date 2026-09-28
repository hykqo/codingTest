import java.util.*;

class Solution {
static int[][] dis = {{-1,0},{0,-1},{1,0},{0,1}};
    static int[][] cache = new int[100][100];

    public int[] solution(String[] maps) {
        List<Integer> answerList = new ArrayList<>();
        for (int i =0; i<maps.length; i++){
            for (int j =0; j<maps[i].length(); j++){
                //방문한적이 있으면?
                if (cache[i][j] == 1) continue;
                //X인 경우는 섬이 아님
                if (maps[i].charAt(j) == 'X') continue;

                //섬계산을 위해 현재 위치 카운팅
                Queue<int[]> queue = new LinkedList<>();
                queue.add(new int[]{i,j});
                cache[i][j] = 1;
                int sumIsland = 0;

                while (!queue.isEmpty()){
                    int[] poll = queue.poll();
                    int thisI = poll[0];
                    int thisJ = poll[1];
                    int thisCnt = maps[thisI].charAt(thisJ) - '0';
                    sumIsland += thisCnt;
                    for (int[] d : dis){
                        int nextI = thisI + d[0];
                        int nextJ = thisJ + d[1];
                        if (nextI<0 || nextI>=maps.length || nextJ<0 || nextJ>=maps[i].length()) continue;
                        int nextCnt = maps[nextI].charAt(nextJ) - '0';
                        //방문한적이 있으면?
                        if (cache[nextI][nextJ] == 1) continue;
                        //X인 경우는 섬이 아님
                        if (maps[nextI].charAt(nextJ) == 'X') continue;
                        //방문한 적이 없으면 체크.
                        cache[nextI][nextJ] = 1;
                        queue.offer(new int[]{nextI, nextJ});
                    }
                }
                if (sumIsland != 0){
                    answerList.add(sumIsland);
                }
            }
        }
        if (answerList.size() == 0) return new int[]{-1};
        Collections.sort(answerList);
        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
}