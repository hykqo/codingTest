package review1.hashMap;

import java.util.HashMap;
import java.util.Scanner;

public class AllFindAnagram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String S = scanner.nextLine();
        String T = scanner.nextLine();
        int res = 0;
        //비교 위해 t hashMap 생성.
        HashMap<Character, Integer> tMap = new HashMap<>();
        for(char c : T.toCharArray()) tMap.put(c, tMap.getOrDefault(c, 0)+1);
        //초기값 셋팅
        HashMap<Character, Integer> sMap = new HashMap<>();
        for(int i=0; i<T.length(); i++){
            sMap.put(S.charAt(i), sMap.getOrDefault(S.charAt(i), 0)+1);
        }
        if(tMap.equals(sMap)) res++;

        int point1 = 0;
        int point2 = T.length()-1;
        while (true){
            char minS = S.charAt(point1);
            sMap.put(minS, sMap.getOrDefault(minS, 1)-1);
            if(sMap.get(minS) == 0) sMap.remove(minS);
            point1++;

            point2++;
            char maxS = S.charAt(point2);
            sMap.put(maxS, sMap.getOrDefault(maxS, 0)+1);
            if(tMap.equals(sMap)) res++;

            if(point2 >= S.length()-1) break;
        }
        System.out.print(res);
    }
}
