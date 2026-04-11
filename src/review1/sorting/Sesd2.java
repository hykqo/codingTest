package review1.sorting;

import java.util.Arrays;
import java.util.Scanner;


public class Sesd2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = scanner.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = scanner.nextInt();
        }

        Arrays.sort(arr);


        //결정 알고리즘 사용
        int lt = 1;
        int rt = arr[n-1];
        int answer = 0;
        while (lt<=rt){
            int mid = (lt+rt)/2;
            int cnt = 1;
            int ep = arr[0];
            for(int a=1; a<n; a++){
                if(arr[a]-ep >=  mid) {
                    ep = arr[a];
                    cnt++;
                }
            }
            if(cnt >= c){
                answer = mid;
                lt = mid+1;
            } else {
                rt = mid-1;
            }
        }
        System.out.println(answer);
    }
}
