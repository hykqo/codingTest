package review1.sorting;

import java.util.Scanner;

public class Shaco {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        int[] brr = new int[n];
        for(int i=0; i<n; i++){
            int x = scanner.nextInt();
            arr[i] = x;
            brr[i] = x;
        }

        for(int i=1; i<n; i++){
            int resIdx = i;
            int targetNum = arr[i];
            for(int j=i-1; j>=0; j--){
                if(targetNum < arr[j]) {
                    resIdx = j;
                    arr[j+1] = arr[j];
                } else break;
            }
            arr[resIdx] = targetNum;
        }


        int minIdx = 0;
        int maxIdx = 0;

        int standardIndex = 0;
        int standard = 0;
        for(int i=0; i<n; i++){
            if(arr[i] != brr[i]) {
                if(standard == 0) {
                    standardIndex = i+1;
                    standard = brr[i];
                }else {
                    if(standard < brr[i]) {
                        minIdx = standardIndex;
                        maxIdx = i+1;
                    }else{
                        maxIdx = standardIndex;
                        minIdx = i+1;
                    }
                }
            }
        }
        System.out.println(maxIdx + " " + minIdx);
    }
}
