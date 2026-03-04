/**
4 3
3 4 1 2
4 3 2 1
3 1 4 2
 * */

package review1.array;

import java.util.Scanner;

public class Mentoring2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] gradeScoreArr = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                gradeScoreArr[i][j] = scanner.nextInt();
            }
        }

        /**
         * 1. 기준사람의 점수와 타겟사람의 점수를 비교
         * 2. 기준사람의 점수가 타겟사람의 점수보다 학년 내내 클 경우 기준사람은 타겟 사람의 멘토가 될 자격이 있음.
         * */
        for(int thisMan=1; thisMan<=n; thisMan++){
            for(int targetMan=1; targetMan<=n; targetMan++){
                if(thisMan == targetMan) continue;
                boolean mentorBool = true;
                for(int grade=0; grade<m; grade++){
                    int thisScore = 0, targetScore = 0;
                    for(int score=0; score<n; score++){
                        int currentMan = gradeScoreArr[grade][score];
                        if(thisMan == currentMan) thisScore = score;
                        else if(targetMan == currentMan) targetScore = score;
                    }
                    if(thisScore < targetScore) mentorBool = false;
                }
                if(mentorBool) System.out.println("("+thisMan+", "+targetMan+")");
            }
        }
    }
}
