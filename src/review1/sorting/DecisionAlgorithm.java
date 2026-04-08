package review1.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class DecisionAlgorithm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(solution(arr, n, m));
    }
    //결정알고리즘 사용
    //결정알고리즘은 이분검색을 활용함.
    //결정알고리즘은 답이 lt~rt사이에 분명히 존재할 경우에만 사용할 수 있음.
    public static int solution(int[] arr, int n, int m){
        int answer = 0;
        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();
        while (lt<=rt){
            int mid = (lt+rt)/2;
            int resCnt = count(arr, mid);
            if(resCnt <= m){
                answer = mid;
                rt = mid-1;
            }else {
                lt = mid+1;
            }
        }
        return answer;
    }

    public static int count(int[] arr, int mid){
        int cnt = 1;
        int sum = 0;
        for(int a : arr){
            if(sum+a <= mid) sum+=a;
            else {
                cnt++;
                sum = a;
            }
        }
        return cnt;
    }
}
