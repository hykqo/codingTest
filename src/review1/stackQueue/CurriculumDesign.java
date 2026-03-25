package review1.stackQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CurriculumDesign {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String n = scanner.next().toUpperCase();
        String m = scanner.next().toUpperCase();

        Queue<Character> nQ = new LinkedList<>();
        for(char c : n.toCharArray()) nQ.add(c);

        String res = "NO";
        for(char c : m.toCharArray()){
            if(nQ.isEmpty()) {
                res = "YES";
                break;
            }
            else if(c == nQ.peek()) nQ.poll();
        }
        System.out.println(res);
    }
}
