package review1.greedy;

import java.util.Scanner;

/*
서로소 문제
union-find 알고리즘

9 7

1 2
2 3
3 4
1 5
6 7
7 8
8 9

3 8

* */
public class DisjointSetUnionFind2 {
    static int[] unf;

    static int find(int x){
        if(unf[x] == x) return x;
        else return unf[x] = find(unf[x]);
    }

    static void union(int x, int y){
        int a = find(x);
        int b = find(y);
        if(a != b) unf[a] = b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        unf = new int[n+1];
        for(int i=1; i<=n; i++) {
            unf[i] = i;
        }

        for (int i=0; i<m; i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            union(a, b);
        }


        int resA = find(scanner.nextInt());
        int resB = find(scanner.nextInt());
        if(resA == resB) System.out.println("YES");
        else System.out.println("NO");
    }
}
