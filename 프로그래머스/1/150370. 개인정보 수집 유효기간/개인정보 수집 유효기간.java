import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
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
}