package review1.stackQueue;

import java.util.*;

public class EmergencyRoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        Queue<Map<Integer, Integer>> queue = new LinkedList<>();
        for(int i=0; i<n; i++){
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(i, scanner.nextInt());
            queue.add(map);
        }

        int cnt = 0;
        while(true){
            Map<Integer, Integer> target = queue.poll();
            Integer targetNum = target.values().stream().findFirst().get();
            Integer targetKey = target.keySet().stream().findFirst().get();
            boolean isLeftBig = false;
            for (int i = 0; i < queue.size(); i++){
                Map<Integer, Integer> left = queue.poll();
                Integer leftNUm = left.values().stream().findFirst().get();
                if(leftNUm > targetNum && !isLeftBig) isLeftBig = true;
                queue.add(left);
            }
            if(isLeftBig) {
                queue.add(target);
            } else{
                cnt++;
                if(targetKey == m) {
                    System.out.println(cnt);
                    break;
                }
            }
        }
    }
}
