package review1.hashMap;

import java.util.HashMap;
import java.util.Scanner;

public class ClassPresident {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String nList = scanner.next();
        char[] members = nList.toCharArray();

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('A',0);
        map.put('B',0);
        map.put('C',0);
        map.put('D',0);
        map.put('E',0);
        for(int i=0; i<n; i++) map.put(members[i], map.get(members[i])+1);

        int max = 0;
        char presidient = 'A';
        for(char key : map.keySet()) {
            if(map.get(key) > max) {
                max = map.get(key);
                presidient = key;
            }
        }
        System.out.println(presidient);
    }
}
