package review1.array;

import java.util.Scanner;

public class Mentoring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //학생수
        int n = scanner.nextInt();
        //시험횟수
        int m = scanner.nextInt();
        //member score
        int[][] score = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                score[i][j] = scanner.nextInt();
            }
        }

        int resultCnt = 0;

        //멘토 학생
        for(int mento=1; mento<=n; mento++){
            //멘티 학생
            for(int mentee=1; mentee<=n; mentee++){
                //멘토 학생과 멘티 학생을 비교
                //시험번호 별로 멘토 학생과 멘티 학생의 등수를 비교
                //멘토 학생은 전체 시험에서 멘티 학생보다 등수가 높아야(숫자가 작아야 높음) 멘토자질이 있음.
                boolean mentoBool = true;
                for(int testNo=0; testNo<m; testNo++){
                    //멘토학생의 등수와 멘티학생의 등수를 추출
                    int mentoRank = 0;
                    int menteeRank = 0;
                    for(int rank=0; rank<n; rank++){
                        //멘토 학생의 등수 추출
                        if(mento == score[testNo][rank]) mentoRank = rank;
                        //멘티 학생의 등수 추출
                        if(mentee == score[testNo][rank]) menteeRank = rank;
                    }
                    //멘토의 등수가 멘티의 등수보타 한번이라도 낮으면 자격 박탈
                    if(mentoRank > menteeRank) {
                        mentoBool = false;
                        break;
                    }
                }
                //멘토 자격을 끝까지 유지한 경우 출력
                //멘토와 멘티가 동일하면 출력 X
                if(mentoBool && mento != mentee) {
                    resultCnt++;
                }
            }
        }
        System.out.println(resultCnt);
    }
}
