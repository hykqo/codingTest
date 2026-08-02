class Solution {
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
}