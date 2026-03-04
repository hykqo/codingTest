package review1.twoPointers;

import java.util.Scanner;

public class MergeTwoArrays {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nList = new int[n];
        for(int i=0; i<n; i++) nList[i] = scanner.nextInt();

        int m = scanner.nextInt();
        int[] mList = new int[m];
        for(int i=0; i<m; i++) mList[i] = scanner.nextInt();

        int nPointer = 0;
        int mPointer = 0;
        int[] res = new int[n+m];

        for(int i=0; i<n+m; i++){

            if(nPointer == n) res[i] = mList[mPointer++];
            else if(mPointer == m) res[i] = nList[nPointer++];
            else{
                if(nPointer <= mPointer) res[i] = nList[nPointer++];
                else res[i] = mList[mPointer++];
            }
        }
        for(int r : res) System.out.print(r+" ");
    }
}
