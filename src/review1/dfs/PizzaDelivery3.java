package review1.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
4 4
0 1 2 0
1 0 2 1
0 2 1 2
2 0 1 2
* */

// 각 거리 계산식 : |x1-x2| + |y1-y2| = 배달거리
//피자집 m개 선택 기준 : 도시의 피자배달거리가 최소가 되는 M개의 피자집 선택.
//각 피자배달거리 : 해당 집과 도시의 존재하는 피자집들과의 거리중 최소값을 해당 집의 피자 배달거리라고 함.
//즉 이 문제는 m개의 피자집을 선택할때 집들과의 거리가 최소가 되는 수를 구하는거임.
//전체중 몇개를 선택하는 문제니까 조합 문제임.
public class PizzaDelivery3 {
    static int n,m, len;
    static List<XY> pizzaHouse = new ArrayList<>();
    static List<XY> house = new ArrayList<>();
    static int[] combi;
    static int answer = Integer.MAX_VALUE;
    public static class XY{
        int x,y;
        public XY(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int calc(XY pizza, XY home){
        return Math.abs(pizza.x-home.x) + Math.abs(pizza.y-home.y);
    }

    static void DFS(int L, int s){
        //현재 레벨이 m개와 같다면? 조합이 완성되었다면 결과 도출.
        if(L==m){
            int sum = 0;
            //집들을 반복하여 가장 최소거리에 있는 피자집들을 계산하여 sum.
            for(XY h : house){
                int dis = Integer.MAX_VALUE;
                //한 집에서 피자집들과의 거리 중 최소거리 추출.
                for (int x : combi){
                    dis = Math.min(dis, calc(pizzaHouse.get(x), h));
                }
                sum+=dis;
            }
            //해당 조합으로 계산된 최소거리와 기존 값중 최소값 추출.
            answer = Math.min(answer, sum);
        }else{
            for (int i=s; i<len; i++){
                combi[L] = i;
                DFS(L+1, i+1);
            }

        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        combi = new int[m];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int x = scanner.nextInt();
                if(x==2) pizzaHouse.add(new XY(i,j));
                else if(x==1) house.add(new XY(i,j));
            }
        }
        len = pizzaHouse.size();
        DFS(0, 0);
        System.out.println(answer);
    }
}
