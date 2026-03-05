package review1.twoPointers;

import java.util.Scanner;

public class ContinuPartialSeq {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] nList = new int[n];
        for(int i=0; i<n; i++) nList[i] = scanner.nextInt();

        int pointer1 = 0;
        int pointer2 = 0;
        int calSum = nList[0];
        int res = 0;
        while(true){
            if(pointer2 + 1 >= n) break;
            if(calSum <= m ) calSum += nList[++pointer2];
            else calSum -= nList[pointer1++];
            if(calSum == m) res++;
        }
        System.out.println(res);
    }
}
