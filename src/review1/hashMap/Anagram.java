package review1.hashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Anagram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String b = scanner.nextLine();

        char[] aKeys = a.toCharArray();
        char[] bKeys = b.toCharArray();

        Map<Character, Integer> aMap = new HashMap<>();
        Map<Character, Integer> bMap = new HashMap<>();
        for(char s : aKeys) aMap.put(s, aMap.getOrDefault(s, 0)+1);
        for(char s : bKeys) bMap.put(s, bMap.getOrDefault(s, 0)+1);

        if(aMap.equals(bMap)) System.out.println("YES");
        else System.out.println("NO");
    }
}
