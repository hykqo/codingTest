package review1.greedy;

import java.util.*;
/*
6
1 4
2 3
3 5
4 6
5 7


3
3 3
1 3
2 3
* */
public class RoomReservation{
    static class MeetingHour implements Comparable<RoomReservation.MeetingHour>{
        int start;
        int end;

        MeetingHour(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(MeetingHour o) {
            if(this.end == o.end) return this.start - o.start;
            else return this.end - o.end;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<MeetingHour> meetingHourList = new ArrayList<>();
        for (int i=0; i<n; i++){
            meetingHourList.add(new MeetingHour(scanner.nextInt(), scanner.nextInt()));
        }
        Collections.sort(meetingHourList);

        int cnt = 0;
        int minEnd = 0;
        for(MeetingHour thisHour : meetingHourList){
            if(thisHour.start >= minEnd) {
                cnt++;
                minEnd = thisHour.end;
            }
        }
        System.out.println(cnt);
    }
}
