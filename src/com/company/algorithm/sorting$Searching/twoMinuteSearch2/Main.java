/*
* 8. 이분검색
설명
임의의 N개의 숫자가 입력으로 주어집니다. N개의 수를 오름차순으로 정렬한 다음 N개의 수 중 한 개의 수인 M이 주어지면
이분검색으로 M이 정렬된 상태에서 몇 번째에 있는지 구하는 프로그램을 작성하세요. 단 중복값은 존재하지 않습니다.

입력
첫 줄에 한 줄에 자연수 N(3<=N<=1,000,000)과 M이 주어집니다.
두 번째 줄에 N개의 수가 공백을 사이에 두고 주어집니다.

출력
첫 줄에 정렬 후 M의 값의 위치 번호를 출력한다.

예시 입력 1
8 32
23 87 65 12 57 32 99 81
예시 출력 1
3
*/


package com.company.algorithm.sorting$Searching.twoMinuteSearch2;


import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = sc.nextInt();

        int res = 0;
        Arrays.sort(arr);
        //이분검색 활용 - 배열이 정렬된 상태에서만 사용 가능.
        // 순차검색은 시간복잡도 o(n)
        // 이분검색은 시간복잡도 o(logN)
        // 이분검색방법은 정렬된 배열에서 index를 통한 data검색에 매우 효율적임.
        // 이분검색 방법 : lt=0, rt=n으로 설정, mid=(lt+rt)/2 설정 이후 lt와 rt를 조건에 따라 옮기면 됨.
        //조건 : mid가 m보다 작을경우 rt = mid-1이 됨.
        //조건 : mid가 m보다 클경우 lt = mid+1이 됨.
        //조건 : mid가 m이랑 같을경우 return;
        //조건 : lt가 rt보다 커질경우 값을 찾지 못한 것이기 때문에 break;

        int lt=0, rt=n-1;
        while (lt<=rt){
            int mid=(lt+rt)/2;
            if(arr[mid]==m){
                res=mid+1;
                break;
            }
            else if(arr[mid]>m) rt=mid-1;
            else lt=mid+1;
        }
        System.out.println(res);
    }
}
