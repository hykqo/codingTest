package review1.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Point implements Comparable<Point>{
    private int a;
    private int b;

    Point(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(Point o) {
        if(this.a == o.a) return this.b - o.b;
        else return this.a - o.a;
    }

    @Override
    public String toString() {
        return a + " " + b;
    }
}

public class SortingCoordinates {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] xrr = new int[n];
        int[] yrr = new int[n];
        List<Point> arr = new ArrayList<>();
        for(int i=0; i<n; i++){
            arr.add(new Point(scanner.nextInt(), scanner.nextInt()));
        }
        Collections.sort(arr);

        for(Point p : arr){
            System.out.println(p.toString());
        }
    }
}
