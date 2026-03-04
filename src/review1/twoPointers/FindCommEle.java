package review1.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FindCommEle {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] nList = new int[n];
        for(int i=0; i<n; i++) nList[i] = scanner.nextInt();

        int m = scanner.nextInt();
        int[] mList = new int[m];
        for(int i=0; i<m; i++) mList[i] = scanner.nextInt();

        //정렬
        Arrays.sort(nList);
        Arrays.sort(mList);

        //포인트 계산
        int nPointer = 0;
        int mPointer = 0;
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<n+m; i++){
            if(nPointer == n || mPointer == m) break;

            int thisN = nList[nPointer];
            int thisM = mList[mPointer];

            if(thisN < thisM) nPointer++;
            else if(thisN > thisM) mPointer++;
            else{
                res.add(thisN);
                nPointer++;
                mPointer++;
            }
        }
        for(int r : res) System.out.print(r+" ");
    }
}
