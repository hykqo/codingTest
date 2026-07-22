package review1.dynamicProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
5
25 3 4
4 4 6
9 2 3
16 2 5
1 5 2
* */
public class BuildingTallestTower {
    static class Brick{
        int width, height, weight;

        Brick(int width, int height, int weight){
            this.width = width;
            this.height = height;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Brick> bricks = new ArrayList<>();
        int[] buildings = new int[n];
        for (int i = 0; i < n; i++){
            int widtht = scanner.nextInt();
            int height = scanner.nextInt();
            int weight = scanner.nextInt();
            Brick brick = new Brick(widtht, height, weight);
            bricks.add(brick);
        }
        if(n == 0) {
            System.out.println(0);
            return;
        }
        buildings[0] = bricks.get(0).height;
        int sum = buildings[0];
        for(int i=1; i<n; i++){
            int maxH = 0;
            Brick brick = bricks.get(i);
            for(int j=i-1; j>=0; j--){
                Brick target = bricks.get(j);
                if(brick.width < target.width && brick.weight < target.weight &&  maxH < buildings[j]){
                    maxH = buildings[j];
                }
            }
        buildings[i] = maxH + brick.height;
        sum = Math.max(sum, buildings[i]);
        }
        System.out.println(sum);
    }

}
