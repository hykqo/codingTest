package review1.stackQueue;

import java.util.Scanner;
import java.util.Stack;

public class Tungsten {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        char[] arr = s.toCharArray();
        int res = 0;
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<arr.length; i++){
            if(arr[i] == '(') stack.push(arr[i]);
            else if(arr[i] == ')') {
                //레이저
                stack.pop();
                if(arr[i-1] == '(') res += stack.size();
                else res++;
            }
        }
        System.out.println(res);
    }
}
