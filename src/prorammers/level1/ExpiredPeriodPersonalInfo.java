package prorammers.level1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpiredPeriodPersonalInfo {

    public class Dt{
        int year;
        int month;
        int day;


        public Dt(String date){
            String[] yyyyMMdd = date.split("\\.");
            this.year = Integer.parseInt(yyyyMMdd[0]);
            this.month = Integer.parseInt(yyyyMMdd[1]);
            this.day = Integer.parseInt(yyyyMMdd[2]);
        }

        public void addExpiredMonth(int month){
            this.month = this.month + month;
            while (this.month > 12) {
                this.month -= 12;
                this.year++;
            }
            minusExpiredDay();
        }

        private void minusExpiredDay(){
            if (this.day == 1) {
                this.day = 28;
                if(this.month == 1) {
                    this.month = 12;
                    this.year = this.year - 1;
                } else{
                    this.month = this.month - 1;
                }
            } else {
                this.day = this.day - 1;
            }
        }

        public boolean isExpired(Dt today){
            if (this.year > today.year) return false;
            else if (this.year == today.year && this.month > today.month) return false;
            else if (this.year == today.year && this.month == today.month && this.day >= today.day) return false;
            else return true;
        }
    }

    //toady = 오늘
    //terms = 개인정보 종류 및 보유기간 { "개인정보종류, 보유기간" }
    //privacies = 개인정보 수집한 목록 {"개인정보수집날찌, 개인정보종류"}
    public int[] solution(String today, String[] terms, String[] privacies) {
        HashMap<String, Integer> termsMap = new HashMap<>();
        for (String term : terms) {
            String[] termSplit = term.split(" ");
            termsMap.put(termSplit[0], Integer.parseInt(termSplit[1]));
        };

        Dt todayDt = new Dt(today);
        List<Integer> answerList = new ArrayList<>();
        int idx = 0;
        for (String privacy : privacies) {
            idx++;
            String[] privacySplit = privacy.split(" ");
            Dt privacyDt = new Dt(privacySplit[0]);
            int privacyMonth = termsMap.get(privacySplit[1]);
            privacyDt.addExpiredMonth(privacyMonth);
            boolean isExpired = privacyDt.isExpired(todayDt);
            if (isExpired){
                answerList.add(idx);
            }
        }
         return answerList.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
        ExpiredPeriodPersonalInfo info = new ExpiredPeriodPersonalInfo();
        int[] solution = info.solution("2022.05.19"
                , new String[]{"A 6", "B 12", "C 3"}
                , new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"});
        for (int s : solution){
            System.out.println(s);
        }
    }
}
