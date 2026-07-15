package review1.greedy;

import java.util.*;

/*
6
50 2
20 1
40 2
60 3
30 3
30 1
* */
public class MaxIncomeScheduler3 {
    static class sched implements Comparable<sched>{
        int money, time;

        public sched(int money, int time){
            this.money = money;
            this.time = time;
        }

        @Override
        public int compareTo(sched ob){
            return ob.money - this.money;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int max = 0;
        List<sched> schedulers = new ArrayList<>();
        for(int i=0; i<n; i++){
            int money = scanner.nextInt();
            int time = scanner.nextInt();
            max = Math.max(max, time);
            schedulers.add(new sched(money, time));
        }
        Collections.sort(schedulers);

        int sum = 0;
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        int j=0;
        for(int i=max; i>=1; i--){
            for(; j<n; j++){
                int thisTime = schedulers.get(j).time;
                if(thisTime<i) break;
                pQ.offer(schedulers.get(j).money);
            }
            if(!pQ.isEmpty()) sum+=pQ.poll();
        }
        System.out.println(sum);
    }
}
