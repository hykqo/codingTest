package review1.string;

import java.util.Scanner;

public class StringLength {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] s = scanner.next().toCharArray();
        char t = scanner.next().toCharArray()[0];
        System.out.println(s);
        System.out.println(t);
        int count = 0;
        for(int i=0; i<s.length; i++){

        }
        for(char c : s.toCharArray()){
            if(c != t) count++;
            else {
                System.out.print(count);
                count = 0;
            }
        }
    }
}
