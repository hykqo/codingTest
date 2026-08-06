class Solution {
static int [][] dis = {{1,0},{-1,0},{0,1},{0,-1}};

    public int solution(String[][] board, int h, int w) {
        String thisColor = board[h][w];
        int answer = 0;
        for (int[] d : dis){
            int targetX = h+d[0];
            int targetY = w+d[1];
            if(targetX < 0 || targetX >= board.length || targetY < 0 || targetY >= board[0].length) continue;

            String targetColor = board[targetX][targetY];
            if(thisColor.equals(targetColor)) answer++;
        }
        return answer;
    }
}