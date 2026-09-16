import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;


class Solution {
 public static class BookTime implements Comparable<BookTime> {
        int startTime;
        int endTime;

        public BookTime(String[] time){
            int startHour = Integer.parseInt(time[0].split(":")[0]);
            int startMinute = Integer.parseInt(time[0].split(":")[1]);
            int endHour = Integer.parseInt(time[1].split(":")[0]);
            int endMinute = Integer.parseInt(time[1].split(":")[1]);

            this.startTime =  startHour * 60 + startMinute;
            this.endTime = endHour * 60 + endMinute + 10;
        }

        @Override
        public int compareTo(BookTime o) {
            return Integer.compare(this.startTime, o.startTime);
        }



    }

    public int solution(String[][] book_time) {
        List<BookTime> bookTimes = new ArrayList<>();
        for (String[] time : book_time){
            bookTimes.add(new BookTime(time));
        }
        bookTimes.sort(null);
        PriorityQueue<BookTime> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.endTime, b.endTime));
        for (BookTime bookTime : bookTimes){
            //가장 빨리 비는 방이 현재 입실 시간 전에 사용 가능하다면?
            if(pq.isEmpty() || pq.peek().endTime <= bookTime.startTime){
                pq.poll(); //기존 객실 재사용
            }
            //현재 예약을 방에 배정
            pq.add(bookTime);
        }
        return pq.size();
    }
}