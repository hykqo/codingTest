package review1.sorting;

import java.util.Scanner;

public class SelectionSort2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scanner.nextInt();
        }

        for(int i=0; i<n-1; i++){
            int minIdx = i;
            for(int j=i-1; j>=0; j--){
                if(arr[minIdx] > arr[j]) {
                    minIdx = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }
        for(int a : arr) {
            System.out.print(a+ " ");
        }
    }
}
