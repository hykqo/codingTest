package review1.sorting;

import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scanner.nextInt();
        }

        //선택정렬 사용
        for(int i=0; i<n-1; i++){
            int minIdx = i;
            for(int j=i+1; j<n; j++){
                if(arr[minIdx] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[minIdx];
                    arr[minIdx] = temp;
                }
            }
        }

        for(int i=0; i<n-1; i++){
            if(arr[i] == m) {
                System.out.println(i+1);
                return;
            }
        }
    }
}
