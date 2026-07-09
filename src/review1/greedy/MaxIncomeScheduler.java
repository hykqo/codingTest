package review1.greedy;

import java.util.*;
import java.util.stream.Collectors;
/*
6
50 2
20 1
40 2
60 3
30 3
30 1
* */
public class MaxIncomeScheduler {

    static class SeminaScheduler implements Comparable<SeminaScheduler>{
        int n, d;

        public SeminaScheduler(int n, int d){
            this.n = n;
            this.d = d;
        }

        @Override
        public int compareTo(SeminaScheduler o) {
            return o.d - this.d;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<SeminaScheduler> schedulers = new ArrayList<>();
        int maxDay = 0;
        for (int i=0; i<n; i++){
            int pay = scanner.nextInt();
            int day = scanner.nextInt();
            maxDay = Math.max(maxDay, day);
            schedulers.add(new SeminaScheduler(pay, day));
        }
        Collections.sort(schedulers);

        int sum = 0;
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        for (int i=maxDay; i>=1; i--){
            for (SeminaScheduler sched : schedulers){
                if(sched.d==i){
                    pQ.add(sched.n);
                }
            }
            sum += pQ.size() == 0 ? 0 : pQ.poll();
        }
        System.out.println(sum);
    }
}
