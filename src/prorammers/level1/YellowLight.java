package prorammers.level1;

import java.util.Scanner;
/*
2
2 1 2
5 1 1

G <= (time - 1) % (G + Y + R)
&&
(time - 1) % (G + Y + R) < G + Y
* */
public interface YellowLight {
    static int[] cache = new int[10001];

    static int solution(int[][] signals) {
        // 모든 신호등 주기의 최소공배수
        int repeatCycle = 1;

        for (int[] signal : signals) {
            int green = signal[0];
            int yellow = signal[1];
            int red = signal[2];

            int cycle = green + yellow + red;

            repeatCycle = lcm(repeatCycle, cycle);
        }

        /*
         * 신호등의 모든 상태 조합은 repeatCycle초마다 반복됩니다.
         *
         * 따라서 1초부터 repeatCycle초까지만 검사하면 됩니다.
         */
        for (int time = 1; time <= repeatCycle; time++) {
            boolean allYellow = true;

            // 현재 시간에 모든 신호등이 노란불인지 검사
            for (int[] signal : signals) {
                if (!isYellow(signal, time)) {
                    allYellow = false;
                    break;
                }
            }

            if (allYellow) {
                return time;
            }
        }

        // 한 주기 동안 동시에 노란불이 된 적이 없음
        return -1;
    }

    /**
     * 해당 신호등이 현재 시간에 노란불인지 확인합니다.
     */
    static boolean isYellow(int[] signal, int time) {
        int green = signal[0];
        int yellow = signal[1];
        int red = signal[2];

        int cycle = green + yellow + red;

        /*
         * 시간은 1초부터 시작하지만 나머지는 0부터 계산하는 것이 편하므로
         * time - 1을 사용합니다.
         */
        int position = (time - 1) % cycle;

        /*
         * 한 주기 안에서:
         *
         * 초록불: 0 ~ green - 1
         * 노란불: green ~ green + yellow - 1
         * 빨간불: green + yellow ~ cycle - 1
         */
        return green <= position
                && position < green + yellow;
    }

    /**
     * 두 수의 최대공약수를 구합니다.
     */
    static int gcd(int a, int b) {
        while (b != 0) {
            int remainder = a % b;
            a = b;
            b = remainder;
        }

        return a;
    }

    /**
     * 두 수의 최소공배수를 구합니다.
     */
    static int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }

    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] signals = new int[n][3];
        for (int i=0; i<n; i++){
            signals[i][0] = scanner.nextInt();
            signals[i][1] = scanner.nextInt();
            signals[i][2] = scanner.nextInt();
        }

        System.out.println(solution(signals));
    }
}
