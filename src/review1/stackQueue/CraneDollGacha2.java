package review1.stackQueue;

import java.util.Scanner;
import java.util.Stack;

public class CraneDollGacha2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] board = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                board[i][j] = scanner.nextInt();
            }
        }

        int m = scanner.nextInt();
        int[] moves = new int[m];
        for(int i=0; i<m; i++){
            moves[i] = scanner.nextInt();
        }

        int cnt = 0;
        Stack<Integer> stack = new Stack<>();
        for(int move : moves) {
            for(int i=0; i<n; i++){
                int target = board[i][move-1];
                if(target != 0) {
                    if(stack.isEmpty() ||  target != stack.peek()){
                        stack.push(target);
                    } else {
                        stack.pop();
                        cnt+=2;
                    }
                    board[i][move-1] = 0;
                    break;
                }
            }
        }
        System.out.println(cnt);
    }
}
