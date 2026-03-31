package review1.sorting;

import java.util.Scanner;

public class InsertSorting2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scanner.nextInt();
        }

        for(int i=1; i<n; i++){
            int tmp = arr[i];
            int tmpIndex = i;
            for(int j=i-1; j>=0; j--){
                //본인(i)보다 대상(j)가 크면 자리를 바꿈.
                if(arr[j] > tmp){
                    arr[j+1] = arr[j];
                    tmpIndex = j;
                }
            }
            arr[tmpIndex] = tmp;
        }
        for(int a : arr) System.out.print(a+" ");
    }
}
