package prorammers.level1;

import java.util.Scanner;

/*
2
2 1 2
5 1 1

3
2 3 2
3 1 3
2 1 1
* */
public interface YellowLight2 {

    //최대 공약수
    static int gcd(int a, int b){
        if(b==0) return a;
        else return gcd(b,a%b);
    }

    //최소 공배수
    static int lcm(int a, int b){
        return a/gcd(a,b)*b;
    }

    static int solution(int[][] signals) {
        //최소 공배수 계산
        int repeatCycle = 1;
        for (int[] signal : signals){
            int green = signal[0];
            int yellow = signal[1];
            int red = signal[2];
            int cycle = green + yellow + red;
            repeatCycle = lcm(repeatCycle, cycle);
        }

        for (int time=1; time<repeatCycle; time++){
            boolean allYellow = true;
            for (int[] signal : signals){
                if(allYellow){
                    allYellow = isYellow(time, signal);
                }
            }
            if(allYellow) return time;
        }
        return -1;
    }

    static boolean isYellow(int time, int[] signal){
        int cycle = signal[0] + signal[1] + signal[2];
        int thisCyclePoint = time % cycle;
        return signal[0] < thisCyclePoint  && thisCyclePoint <= signal[0] + signal[1];
    }

    public static void main(String[] args) {
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

