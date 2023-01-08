/*
* 12. 멘토링
설명
현수네 반 선생님은 반 학생들의 수학점수를 향상시키기 위해 멘토링 시스템을 만들려고 합니다.
멘토링은 멘토(도와주는 학생)와 멘티(도움을 받는 학생)가 한 짝이 되어 멘토가 멘티의 수학공부를 도와주는 것입니다.
선생님은 M번의 수학테스트 등수를 가지고 멘토와 멘티를 정합니다.
만약 A학생이 멘토이고, B학생이 멘티가 되는 짝이 되었다면, A학생은 M번의 수학테스트에서 모두 B학생보다 등수가 앞서야 합니다.
M번의 수학성적이 주어지면 멘토와 멘티가 되는 짝을 만들 수 있는 경우가 총 몇 가지 인지 출력하는 프로그램을 작성하세요.


입력
첫 번째 줄에 반 학생 수 N(1<=N<=20)과 M(1<=M<=10)이 주어진다.
두 번째 줄부터 M개의 줄에 걸쳐 수학테스트 결과가 학생번호로 주어진다. 학생번호가 제일 앞에서부터 1등, 2등, ...N등 순으로 표현된다.
만약 한 줄에 N=4이고, 테스트 결과가 3 4 1 2로 입력되었다면 3번 학생이 1등, 4번 학생이 2등, 1번 학생이 3등, 2번 학생이 4등을 의미합니다.

출력
첫 번째 줄에 짝을 만들 수 있는 총 경우를 출력합니다.


예시 입력 1
4 3
3 4 1 2
4 3 2 1
3 1 4 2

예시 출력 1
3
*/
package com.company.algorithm.array.mentoring;

import java.util.Scanner;

public class Main {

    public int result(int n, int m, int[][] arr){
        //i=학생(열), j=다른학생(열), k=테스트(행)
        int cnt = 0;
        for(int i=0; i<n; i++) {
            boolean bool = false;
            for (int j=0; j<n; j++) {
                for(int k=0; k<m; k++){
                    System.out.println("[i : "+i+"], "+"[j : "+j+"], "+"[k : "+k+"]");
                    System.out.println("arr[k][i]" + arr[k][i]);
                    System.out.println("arr[k][j]" + arr[k][j]);
                    System.out.println("===============================================");
                    if(i != j && arr[k][i] > arr[j][i]) bool = true;
                }
            }
            if(bool) cnt++;
        }
        return cnt;
    }


    public static void main(String[] args) {
        Main res = new Main();
        Scanner sc = new Scanner(System.in);
        //학생수(열)
        int n = sc.nextInt();
        //수학테스트 횟수(행)
        int m = sc.nextInt();
        int[][] arr = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                System.out.print("0 ");
//                arr[m][n] = sc.nextInt();
            }
            System.out.println("");
        }
        System.out.println(res.result(n, m, arr));
    }
}
