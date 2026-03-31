package review1.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class DuplicateConfirm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scanner.nextInt();
        }

        //선택정렬 사용
//        for(int i=0; i<n; i++){
//            int minIdx = i;
//            for(int j=i+1; j<n; j++) {
//                if(arr[minIdx] > arr[j]) minIdx = j;
//            }
//            int temp = arr[i];
//            arr[i] = arr[minIdx];
//            arr[minIdx] = temp;
//        }

        Arrays.sort(arr);

        //정렬 후 현재값과 다음값 비교하여 동일한 숫자 있을경우 break 및 반환처리.
        String res = "U";
        for(int i=0; i<n-1; i++) {
            if(arr[i] == arr[i+1]) {
                res = "D";
                break;
            }
        }
        System.out.print(res);
    }
}
