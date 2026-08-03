class Solution {
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
}