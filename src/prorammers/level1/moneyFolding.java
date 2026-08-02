package prorammers.level1;

import java.util.Scanner;
/*
30 15
26 17

50 50
100 241
* */
public class moneyFolding {

    public static int solution(int[] wallet, int[] bill) {
        int walletWidth = wallet[0];
        int walletHeight = wallet[1];
        int billWidth = bill[0];
        int billHeight = bill[1];
        int answer = 0;
        while(isImpossible(walletWidth, walletHeight, billWidth, billHeight)){
            int[] folding = folding(billWidth, billHeight);
            billWidth = folding[0];
            billHeight = folding[1];
            answer++;
        }
        return answer;
    }

    public static int[] folding(int billWidth, int billHeight){
        if(billWidth >= billHeight) billWidth /= 2;
        else billHeight /= 2;
        return new int[]{billWidth, billHeight};
    }

    public static boolean isImpossible(int walletWidth, int walletHeight, int billWidth, int billHeight){
        if(walletWidth >= billWidth && walletHeight >= billHeight) return false;
        else if(walletWidth >= billHeight && walletHeight >= billWidth) return false;
        else return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        int[] wallet = {Integer.parseInt(s1.split(" ")[0]), Integer.parseInt(s1.split(" ")[1])};
        int[] bill = {Integer.parseInt(s2.split(" ")[0]), Integer.parseInt(s2.split(" ")[1])};

        System.out.println(solution(wallet, bill));
    }
}
