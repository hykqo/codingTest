package review1.stackQueue;

import java.util.Scanner;
import java.util.Stack;

public class CorrectParentheses {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        Stack<Character> stack = new Stack<>();
        String res = "YES";
        for(char c : next.toCharArray()) {
            if(c == '(') stack.push(c);
            else{
                if(stack.isEmpty()) {
                    res = "NO";
                    break;
                }
                stack.pop();
            }
        }
        System.out.println(res);
    }
}
