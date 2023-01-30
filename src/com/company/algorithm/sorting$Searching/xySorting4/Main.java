/*
* 7. 좌표 정렬
설명
N개의 평면상의 좌표(x, y)가 주어지면 모든 좌표를 오름차순으로 정렬하는 프로그램을 작성하세요.
정렬기준은 먼저 x값의 의해서 정렬하고, x값이 같을 경우 y값에 의해 정렬합니다.

입력
첫째 줄에 좌표의 개수인 N(3<=N<=100,000)이 주어집니다.
두 번째 줄부터 N개의 좌표가 x, y 순으로 주어집니다. x, y값은 양수만 입력됩니다.

출력
N개의 좌표를 정렬하여 출력하세요.

예시 입력 1
5
2 7
1 3
1 2
2 5
3 6
예시 출력 1
1 2
1 3
2 5
2 7
3 6*/

package com.company.algorithm.sorting$Searching.xySorting4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    static class Point implements Comparable<Point>{

        public int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        //x,y값 정렬 기준 셋팅.
        @Override
        public int compareTo(Point o) {
            //정렬은 앞에서 뒤순으로 정렬 시도.
            //this가 앞, o가 뒤
            //오름차순으로 하기 위해 음수가 리턴되도록 처리(this - o).
            if(this.x==o.x) return this.y-o.y;
            else return this.x-o.x;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //Comparable 활용 x,y좌표는 그냥 해당 인터페이스를 사용하자.
        ArrayList<Point> arr = new ArrayList<>();
        for(int i=0; i<n; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr.add(new Point(x, y));
        }
        //Collections의 정렬 기능 활용.
        Collections.sort(arr);
        for(Point o : arr) System.out.println(o.toString());
    }
}
