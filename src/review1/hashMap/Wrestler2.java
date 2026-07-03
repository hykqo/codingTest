package review1.hashMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
5
172 67
183 65
180 70
170 72
181 60
* */

public class Wrestler2 {
    static class Body implements Comparable<Body>{
        int h,w;

        public Body(int h, int w) {
            this.h = h;
            this.w = w;
        }

        @Override
        public int compareTo(Body o) {
            return  o.h - this.h;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Body> manList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int h = sc.nextInt();
            int w = sc.nextInt();
            manList.add(new Body(h,w));
        }



        //1. 선택절차 (문제의 구조에 맞게 정의) --> (좌표정렬 - 키 몸무게중 키로 정렬)
        //2. 선택 절차에 따라 선택을 수행. (키로 정렬 후 정렬된 키의 몸무게 선택)
        //3. 적절성검사 (선택된 해가 문제의 조건을 만족하는지 검사) --> (정렬된 몸무게중에서 자기 몸무게보다 높은사람 있는지 체크)
        //4. 조건을 만족하지 않으면 해당 해를 제외 --> (자기 몸무게보다 높은 사람 있다면 제외)
        //5. 모든 선택이 완료되면 해답을 검사 --> 남은 인원 계산.

        Collections.sort(manList);
        int wMax = Integer.MIN_VALUE;
        int cnt = 0;
        for (Body body : manList) {
            if(body.w > wMax){
                wMax = body.w;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
