package review1.stackQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SavePrincess {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        Queue<Integer> princeList = new LinkedList<>();
        for(int i=1; i<=n; i++){
            princeList.add(i);
        }

        while (princeList.size() > 1){
            for(int i=0; i<k-1; i++) princeList.add(princeList.remove());
            princeList.poll();
        }
        System.out.println(princeList.poll());
    }
}
