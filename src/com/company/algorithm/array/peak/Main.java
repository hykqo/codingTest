/*
* 10. 봉우리
설명
지도 정보가 N*N 격자판에 주어집니다. 각 격자에는 그 지역의 높이가 쓰여있습니다.
각 격자판의 숫자 중 자신의 상하좌우 숫자보다 큰 숫자는 봉우리 지역입니다. 봉우리 지역이 몇 개 있는 지 알아내는 프로그램을 작성하세요.
격자의 가장자리는 0으로 초기화 되었다고 가정한다.
만약 N=5 이고, 격자판의 숫자가 다음과 같다면 봉우리의 개수는 10개입니다.

0 0 0 0 0 0 0
0 5 3 7 2 3 0
0 3 7 1 6 1 0
0 7 2 5 3 4 0
0 4 3 6 4 1 0
0 8 7 3 5 2 0
0 0 0 0 0 0 0

입력
첫 줄에 자연수 N이 주어진다.(2<=N<=50)

두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는다.


출력
봉우리의 개수를 출력하세요.


예시 입력 1
5
5 3 7 2 3
3 7 1 6 1
7 2 5 3 4
4 3 6 4 1
8 7 3 5 2

예시 출력 1
10
*
* 1. 상하좌우 탐색을 위한 배열을 설정해주자.{-1, 0, 1, 0}, {0, 1, 0, -1}
* 2. 인입받은 이중배열을 3중 반복문에 넣고 돌리자.
* 3. 1중과 2중반복은 이중배열의 현재위치를 찾기 위함이고,
* 4. 3중째에서 상하좌우 탐색을 하자.
* 5. 탐색을 할때에 경계선에 위치한 인덱스에서는 상하좌우탐색이 안되서 에러가 터진다.
* 6. 따라서 경계선에 위치했을 경우에는 탐색이 안되도록 하자.
* */
package com.company.algorithm.array.peak;

import java.util.Scanner;

public class Main {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    public int result(int n, int[][] arr){
        int res = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                boolean flag = true;
                //상하좌우 탐색 시작
                for(int k=0; k<4; k++){
                    //행의 상하좌우 탐색
                    int nx = i+dx[k];
                    //열의 상하좌우 탐색
                    int ny = j+dy[k];
                    //행의 상하좌우 탐색시 nx가 0보다 작거나 nx가 5(배열끝)보다 클 경우 제외.
                    //열의 상하좌우 탐색시 nx가 0보다 작거나 nx가 5(배열끝)보다 클 경우 제외.
                    if(nx>=0 && nx<n && ny>=0 && ny<n && arr[nx][ny] >= arr[i][j]) {
                        flag = false;
                        break;
                    }
                }
                if(flag) res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(m.result(n, arr));
    }
}
