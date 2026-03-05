package review1.twoPointers;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MaxLengthContinuSubSequemce {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scanner.nextInt();
        }

        int p1 = 0;
        int p2 = 0;
        int max = 0;
        Queue<Integer> convertQueue = new LinkedList<>();
        while (true){
            p2++;
            if(p2 >= n) break;
            if(arr[p2] == 0){
                if(convertQueue.size() == k) {
                    p1 = convertQueue.poll()+1;
                }
                convertQueue.add(p2);
            }
            int thisSum = p2 - p1 + 1;
            max = Math.max(thisSum, max);
        }
        System.out.println(max);
    }
}
