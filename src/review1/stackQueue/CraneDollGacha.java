package review1.stackQueue;

import java.util.*;

public class CraneDollGacha {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[][] board = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                board[i][j] = scanner.nextInt();
            }
        }

        int movesLength = scanner.nextInt();

        int[] moves = new int[movesLength];
        for(int i=0; i<movesLength; i++) {
            moves[i] = scanner.nextInt();
        }

        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for(int move : moves) {
            for(int i=0; i<n; i++) {
                if(board[i][move-1] != 0) {
                    int tmp = board[i][move-1];
                    board[i][move-1] = 0;
                    if(!stack.isEmpty() && tmp == stack.peek()) {
                        res+=2;
                        stack.pop();
                    } else stack.push(tmp);
                    break;
                }
            }
        }
        System.out.println(res);

    }
}
