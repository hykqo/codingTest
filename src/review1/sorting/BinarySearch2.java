package review1.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scanner.nextInt();
        }

        //이분검색은 반드시 정렬이 되어야 함. 이분검색은 o(log n)임
        Arrays.sort(arr);
        int lt = 0;
        int rt = n-1;
        int mid = (lt+rt) / 2;
        while (lt<=rt){
            if(m > arr[mid]) {
                lt = mid+1;
                mid = (lt+rt)/2;
            }else if(m < arr[mid]){
                rt = mid-1;
                mid = (lt+rt)/2;
            } else {
                System.out.println(mid+1);
                break;
            }
        }
    }
}
