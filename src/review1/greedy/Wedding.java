package review1.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
5
14 18
12 15
15 20
20 30
5 14
* */
public class Wedding {
    static class Timing implements Comparable<Timing> {
        int time;
        String type;

        Timing(int time, String type){
            this.time = time;
            this.type = type;
        }

        @Override
        public int compareTo(Timing o) {
            if(this.time == o.time) return this.type.compareTo(o.type);
            else return this.time - o.time;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Timing> timelist = new ArrayList<>();
        for(int i=0; i<n; i++) {
            timelist.add(new Timing(scanner.nextInt(), "s"));
            timelist.add(new Timing(scanner.nextInt(), "e"));
        }

        Collections.sort(timelist);

        int answer = Integer.MIN_VALUE;
        int cnt = 0;
        for (Timing t : timelist) {
            System.out.println(t.time + " " + t.type);
            if(t.type.equals("s")) cnt++;
            else cnt--;
            answer = Math.max(answer, cnt);
        }

        System.out.println(answer);
    }
}
