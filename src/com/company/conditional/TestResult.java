package com.company.conditional;
/*
* 문제
시험 점수를 입력받아 90 ~ 100점은 A, 80 ~ 89점은 B, 70 ~ 79점은 C, 60 ~ 69점은 D, 나머지 점수는 F를 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 시험 점수가 주어진다. 시험 점수는 0보다 크거나 같고, 100보다 작거나 같은 정수이다.

출력
시험 성적을 출력한다.*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class TestResult {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputScore = br.readLine();
        int score = 0;
        try {
            score = Integer.parseInt(inputScore);
        }catch (NumberFormatException e) {
            System.err.println("정수만 입력 바랍니다.");
        }
        if (score < 0 || score > 100) throw  new Exception("시험 점수는 0보다 크거나 같고, 100보다 작아야 합니다.");
        switch (score/10) {
            case  10 : System.out.println("A"); break;
            case  9 : System.out.println("A"); break;
            case  8 : System.out.println("B"); break;
            case  7 : System.out.println("C"); break;
            case  6 : System.out.println("D"); break;
            default : System.out.println("F");
        }
    }
}
