package review1.hashMap;


import java.util.HashMap;
import java.util.Scanner;

public class TypeOfSales {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int [] sales = new int[n];
        for(int i=0; i<n; i++) sales[i] = scanner.nextInt();

        //defaultSet
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<k; i++) map.put(sales[i], map.getOrDefault(sales[i], 0)+1);
        System.out.print(map.size()+" ");
        int p1=0, p2=k;
        while(true){
            if(p2 == n) break;
            //다음 매출 set
            Integer nextMinSalesPoint = map.getOrDefault(sales[p1], 1)-1;
            //map에 값 셋팅.
            if(nextMinSalesPoint == 0) map.remove(sales[p1]);
            else map.put(sales[p1], nextMinSalesPoint);
            p1++;

            Integer nextMaxSalesPoint = map.getOrDefault(sales[p2], 0)+1;
            map.put(sales[p2], nextMaxSalesPoint);

            System.out.print(map.size() + " ");
            p2++;
        }
    }
}
