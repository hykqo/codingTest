package review1.sorting;

import java.util.Scanner;

public class LeastRecentlyUsed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt();
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scanner.nextInt();
        }

        int[] srr = new int[s];

        for(int i=0; i<n; i++){
            boolean isFull = true;
            for(int j=0; j<s; j++){
                //비어있는 것
                if(srr[j] == 0) {
                    srr[j] = arr[i];
                    isFull = false;
                    break;
                } else if(srr[j] == arr[i]) {
                    for(int k=j; k>0; k--){
                        srr[k] = srr[k-1];
                    }
                    srr[0] = arr[i];
                    isFull = false;
                    break;
                }
            }
            if(isFull) {
                for(int k=s-1; k>0; k--){
                    srr[k] = srr[k-1];
                }
                srr[0] = arr[i];
            }
        }
        for(int ss : srr) System.out.print(ss + " ");
    }
}
