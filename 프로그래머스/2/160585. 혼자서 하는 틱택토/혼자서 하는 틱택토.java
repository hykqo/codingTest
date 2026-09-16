class Solution {

    public static class Player {
        int turn;
        int[][] coord;

        public Player(int boardRowSize, int boardColSize){
            this.turn = 0;
            this.coord = new int[boardRowSize][boardColSize];
        }
    }

    public static int solution(String[] board) {
        int answer = -1;
        Player playerO = new Player(board[0].length(), board.length);
        Player playerX = new Player(board[0].length(), board.length);

        for (int i=0; i<board.length; i++){
            for (int j=0; j<board[i].length(); j++){
                if (board[i].charAt(j) == 'O') {
                    playerO.turn += 1;
                    playerO.coord[i][j] = 1;
                }
                else if (board[i].charAt(j) == 'X') {
                    playerX.turn += 1;
                    playerX.coord[i][j] = 1;
                }
            }
        }
        // 2. 기본적인 턴 개수 검사
        // O가 선공이므로:
        // O == X 또는 O == X + 1이어야 한다.
        if (playerO.turn < playerX.turn) return 0;
        if (playerO.turn > playerX.turn + 1) return 0;
        // 3. 각각 승리했는지 확인
        boolean oWin = isWin(playerO.coord);
        boolean xWin = isWin(playerX.coord);
        // 4. O와 X가 모두 승리한 상황은 불가능
        if (oWin && xWin) return 0;
        // 5. O가 승리했다면 O가 마지막으로 놓은 상태여야 한다.
        if (oWin && playerO.turn != playerX.turn + 1) return 0;
        // 6. X가 승리했다면 X가 마지막으로 놓은 상태여야 한다.
        if (xWin && playerO.turn != playerX.turn) return 0;
        return 1;
    }

    private static boolean isWin(int[][] coord) {
        // 가로 검사
        for (int row = 0; row < 3; row++) {
            if (coord[row][0] == 1
                    && coord[row][1] == 1
                    && coord[row][2] == 1) {
                return true;
            }
        }

        // 세로 검사
        for (int col = 0; col < 3; col++) {
            if (coord[0][col] == 1
                    && coord[1][col] == 1
                    && coord[2][col] == 1) {
                return true;
            }
        }

        // 왼쪽 위 → 오른쪽 아래 대각선
        if (coord[0][0] == 1
                && coord[1][1] == 1
                && coord[2][2] == 1) {
            return true;
        }

        // 오른쪽 위 → 왼쪽 아래 대각선
        if (coord[0][2] == 1
                && coord[1][1] == 1
                && coord[2][0] == 1) {
            return true;
        }
        return false;
    }
}