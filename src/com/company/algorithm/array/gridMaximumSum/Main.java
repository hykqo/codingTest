/*
* 9. 격자판 최대합
설명

5*5 격자판에 아래롸 같이 숫자가 적혀있습니다.

10 13 10 12 15
12 39 30 23 11
11 25 50 53 15
19 27 29 37 27
19 13 30 13 19

N*N의 격자판이 주어지면
1. 각 행의 합
2. 각 열의 합
3. 두 대각선의 합
중 가 장 큰 합을 출력합니다.


입력
첫 줄에 자연수 N이 주어진다.(2<=N<=50)
두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는다.


출력
최대합을 출력합니다.


예시 입력 1
5
10 13 10 12 15
12 39 30 23 11
11 25 50 53 15
19 27 29 37 27
19 13 30 13 19
예시 출력 1

155
*
* 1. 2차원배열을 만든다. arr[행][열]
* 2. 최대값을 저장할 변수와 행의 값과 열의 값을 저장할 변수를 만든다.
* 3. 2중 반복문을 이용하여 1개행의 값과 1개열의 값을 구한다.
* 4. 1중 반복문안에서 구한 행과 열을 비교하여 res에 담는다.
* 5. 반복문이 완료되면 최대값만 나온다.
* 6. 대각선 값을 구하기 위해 반복문을 만든다.
* 7. 반복문 안에서 각 대각선의 값을 구한뒤 변수에 넣는다.
* 8. res의 값과 구한 값을 비교하여 최대값을 얻는다.
* */
package com.company.algorithm.array.gridMaximumSum;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public int result(int n, int[][] arr){
        //Math함수를 이용해서 최대값을 구할 것이기 떄문에, res에 최소단위를 입력해주자.
        int res = Integer.MIN_VALUE;
        //행의 합과 열의 합을 구할 변수 생성
        int sum1, sum2;
        //전체 행의 값과 전체 열의 값을 비교해서 그중 최대값을 구해보자
        for(int i=0; i<n; i++){
            sum1=sum2=0;
            //열
            for(int j=0; j<n; j++){
                //행은 고정되고 열만 움직이므로 한개 행의 값을 구할 수 있다.
                sum1+=arr[i][j];
                //열은 고정되고 행만 움직이므로 한개 열의 값을 구할 수 있다.
                sum2+=arr[j][i];
            }
            //Math의 최대값 기능을 이용하자.
            res = Math.max(res, sum1);
            res = Math.max(res, sum2);
        }
        //양쪽 대각선의 값을 구해보자
        sum1=sum2=0;
        for(int i = 0; i<n; i++){
            sum1+=arr[i][i];
            sum2+=arr[i][n-i-1];
        }
        res = Math.max(res, sum1);
        res = Math.max(res, sum2);
        return res;
    }

    public static void main(String[] args) throws IOException {
        Main m =new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for(int i = 0; i<n; i++)
            for(int j = 0; j<n; j++)
                    arr[i][j] = sc.nextInt();
        System.out.println(m.result(n, arr));
    }
}
