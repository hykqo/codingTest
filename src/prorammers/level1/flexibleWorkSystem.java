package prorammers.level1;

import java.util.Scanner;

/*
n
schedules
timelogs
startday
result

3
700 800 1100
710 2359 1050 700 650 631 659
800 801 805 800 759 810 809
1105 1001 1002 600 1059 1001 1100
5

res = 3


4
730 855 700 720
710 700 650 735 700 931 912
908 901 805 815 800 831 835
705 701 702 705 710 710 711
707 731 859 913 934 931 905
1

res = 2

* */
public class flexibleWorkSystem {
    static int[] schedules;
    static int[][] timelogs;
    static int startday;

    public static int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        for (int personIdx = 0; personIdx<schedules.length; personIdx++){
            // i = 사람
            //특정인의 출근 해야하는 시간.
            int schedulerWorkTime = schedules[personIdx];
            boolean isLate = false;
            int logIdx=0;
            for (int day = startday; day<startday+7; day++){
                int thisDayWeek = day%7;
                int startedWorkTime =  timelogs[personIdx][logIdx];
                boolean lateCheck = LateWorkCheck(thisDayWeek, schedulerWorkTime, startedWorkTime);
                if(lateCheck) {
                    isLate = true;
                    break;
                }
                logIdx++;
            }
            if(!isLate) answer++;
        }

        return answer;
    }

    //지각 여부 체크
    // 지각 : true
    public static boolean LateWorkCheck(int thisDayWeek, int schedulerWorkTime, int  startedWorkTime) {
        if (thisDayWeek == 0 || thisDayWeek == 6 || thisDayWeek == 7) return false;

        int schedulerWorkMinute = (schedulerWorkTime / 100 * 60) + (schedulerWorkTime % 100);
        int suspendedMinute = schedulerWorkMinute + 10;
        int startedWorkMinute = (startedWorkTime / 100 * 60) + (startedWorkTime % 100);
        //늦게 출근했다면 true
        boolean res = suspendedMinute < startedWorkMinute;
        return res;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        schedules = new int[n];
        //출근 히망 시각 ex) 700=7:00, 1100=11:00
        for(int i=0; i<n; i++){
            schedules[i] = scanner.nextInt();
        }
        timelogs = new int[n][7];
        //일주일동안의 출근 기록 ex) 710=7:10, 659=6:59
        for(int i=0; i<n; i++){
            for(int j=0; j<7; j++){
                timelogs[i][j] = scanner.nextInt();
            }
        }


        //출근 시작요일 ex)1=월요일, 7=일요일
        // 출근시작일로부터 일주일동안 출근이 수행되었음.
        startday = scanner.nextInt();

        //출근희망시각+10분보다 출근기록만 존재하는 index들의 카운트 밪ㄴ환
        System.out.println(solution(schedules, timelogs, startday));
    }
}
