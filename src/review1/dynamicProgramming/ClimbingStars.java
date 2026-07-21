package review1.dynamicProgramming;

import java.util.Scanner;
/*
* 다이나믹 프로그래밍
* 복잡다고 큰 경우 작은 문제로 쪼개어 복잡도를 해결할 수 있다,
* 즉 문제를 소형화 시키고 문제의 본질은 유지시키어 문제해결 난이도를 낮추는 방법이다.
* 아래는 계단을 오를때 한번에 1계단 혹은 2계단씩 올라간다는 규칙이 있기 때문에, 1계단과 2계단의 갯수를 미리 구해논 후에.
* 3계단을 올라갈때 피보나치의 법칙을 이용해 계산한 알고리즘이다.
* */
public class ClimbingStars {
    static int[] dy;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        dy = new int[n+1];
        dy[1] = 1;
        dy[2] = 2;
        for (int i=3; i<=n; i++){
            dy[i] = dy[i-1] + dy[i-2];
        }
        System.out.println(dy[n]);
    }
}
