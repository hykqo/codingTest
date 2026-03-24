package review1.stackQueue;

import java.util.Scanner;
import java.util.Stack;

public class Postfix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] sList = s.toCharArray();

        int res = 0;
        Stack<Character> stack = new Stack<>();
        for(char c : sList){
            if(c != '*' && c != '+' && c != '-' && c != '/') {
              stack.push(c);
            } else {
                if(stack.size() < 2) return;
                int rt = stack.pop() - '0',
                    lt = stack.pop() - '0';
                if(c == '*') res = lt * rt;
                else if(c == '+') res = lt+rt;
                else if(c == '-') res = lt-rt;
                else res = rt/lt;
                stack.push((char)(res + '0'));
            }
        }
        System.out.println(res);
    }
}
