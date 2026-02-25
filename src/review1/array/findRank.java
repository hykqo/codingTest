package review1.array;

import java.util.Scanner;

public class findRank {

    public static int solution(int[] arr, int target){
        int rank = 1;
        for(int a : arr){
            if(a > target) rank++;
        }
        return rank;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scanner.nextInt();
        }

        for(int a : arr){
            System.out.print(solution(arr, a) + " ");
        }
    }

}
