package prorammers.level2;

import java.util.*;

public class AssignmentProgress {

    public class Assignment implements Comparable<Assignment> {
        String name;
        int start;
        int playTime;


        public Assignment(String[] plan){
            this.name = plan[0];
            this.start = getHourMinute(plan[1]);
            this.playTime = Integer.parseInt(plan[2]);
        }

        private int getHourMinute(String time){
            String[] split = time.split(":");
            int hour = Integer.parseInt(split[0]);
            int minute = Integer.parseInt(split[1]);
            return hour * 60 + minute;
        }

        @Override
        public int compareTo(Assignment o) {
            return Integer.compare(this.start, o.start);
        }
    }

    public String[] solution(String[][] plans) {
        Assignment[] assignments = new Assignment[plans.length];
        Deque<Assignment> paused = new ArrayDeque<>();
        for (int i=0; i<plans.length; i++){
            assignments[i] = new Assignment(plans[i]);
        }
        // 시작시간 순으로 최초 한 번 정렬
        Arrays.sort(assignments, Comparator.comparingInt(a -> a.start));
        List<String> answer = new ArrayList<>();

        for (int i=0; i<assignments.length-1; i++){
            Assignment current = assignments[i];
            Assignment next = assignments[i+1];
            int availableTime = next.start - current.start;

            //과제를 끝낼 수 없을 경우
            if(current.playTime > availableTime) {
                current.playTime -= availableTime;
                paused.push(current);
                continue;
            }
            //현재 과제 완료
            answer.add(current.name);

            //이용가능시간 - playTime = //다음 과제 시작전까지 수행가능한 타임.
            int remainTime = availableTime - current.playTime;
            while (remainTime > 0 && !paused.isEmpty()){
                Assignment pausedAssignment = paused.pop();

                if (pausedAssignment.playTime <= remainTime) {
                    remainTime -= pausedAssignment.playTime;
                    answer.add(pausedAssignment.name);
                } else{
                    pausedAssignment.playTime -= remainTime;
                    paused.push(pausedAssignment);
                    break;
                }
            }
        }
        //마지막 과제 수행
        answer.add(assignments[assignments.length-1].name);
        //남아있는 과제 수행.
        while (!paused.isEmpty()){
            answer.add(paused.pop().name);
        }
        return answer.toArray(new String[0]);
    }

    public static void main(String[] args) {
        AssignmentProgress assignmentProgress = new AssignmentProgress();
        assignmentProgress.solution(new String[][]{{"korean", "11:40", "30"}, {"english", "12:10", "20"}, {"math", "12:30", "40"}});
    }
}
