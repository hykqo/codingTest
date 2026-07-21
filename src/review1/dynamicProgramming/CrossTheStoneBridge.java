package review1.dynamicProgramming;

import java.util.Scanner;

/*
* 돌다리 건너기.
* n개의 돌로 다리를 만들어 둠.
* 한번에 한칸 내지 두칸씩 건너뛰면서 돌다리를 건널 수 있음.
* 개울을 건널수 있는 방법은 몇가지인지 구해야 함.
*
* */
public class CrossTheStoneBridge {
    public static void main(String[] args) {
        //다리를 건너서 넘어가야 하므로 돌 n개를 건너고 다음 땅으로 가야함. 그래서 사실 n+1임.
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] dy = new int[n+2];
        dy[1] = 1;
        dy[2] = 2;
        for(int i=3; i<=n+1; i++){
            dy[i] = dy[i-2] + dy[i-1];
        }
        System.out.println(dy[n+1]);
    }
}
