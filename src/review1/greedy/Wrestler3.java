package review1.greedy;

/*
5
172 67
183 65
180 70
170 72
181 60
* */

import java.util.Scanner;

public class Wrestler3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] Hrr = new int[n];
        int[] Wrr = new int[n];

        for(int i=0; i<n; i++){
            Hrr[i] = scanner.nextInt();
            Wrr[i] = scanner.nextInt();
        }

        for(int i=0; i<n; i++){
            for (int j=i+1; j<n; j++){
                if(Hrr[i] < Hrr[j]){
                    int tempH = Hrr[i];
                    Hrr[i] = Hrr[j];
                    Hrr[j] = tempH;

                    int tempW = Wrr[i];
                    Wrr[i] = Wrr[j];
                    Wrr[j] = tempW;
                }
            }
        }

        int res = 1;
        int maxW = Wrr[0];
        for (int i=1; i<n; i++){
            if(Wrr[i] > maxW){
                maxW = Wrr[i];
                res++;
            }
        }
        System.out.println(res);
    }
}
