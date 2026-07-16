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
public class DisjointSetUnionFind {
    static int[] unf; //집합 - 특정 학생 인덱스에 집합번호를 저장함.

    public static int find(int x){
        if(unf[x] == x) return x;
        return unf[x] = find(unf[x]);
    }

    public static void union(int x, int y){
        int fa = find(x);
        int fb = find(y);
        if(fa != fb) unf[fa] = fb;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        unf = new int[n+1];
        for(int i=1; i<=n; i++) {
            unf[i] = i;
        }
        for(int i=0; i<m; i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            union(a, b);
        }
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int fa = find(a);
        int fb = find(b);
        System.out.println(fa == fb ? "YES" : "NO");
    }
}
