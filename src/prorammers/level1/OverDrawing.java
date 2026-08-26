package prorammers.level1;

/*
입출력 예 #1
예제 1번은 2, 3, 6번 영역에 페인트를 다시 칠해야 합니다. 롤러의 길이가 4미터이므로 한 번의 페인트칠에 연속된 4개의 구역을 칠할 수 있습니다.
처음에 3, 4, 5, 6번 영역에 페인트칠을 하면 칠해야 할 곳으로 2번 구역만 남고 1, 2, 3, 4번 구역에 페인트칠을 하면 2번 만에 다시 칠해야 할 곳에 모두 페인트칠을 할 수 있습니다.
2번보다 적은 횟수로 2, 3, 6번 영역에 페인트를 덧칠하는 방법은 없습니다.
따라서 최소 횟수인 2를 return 합니다.

입출력 예 #2
예제 2번은 1, 3번 영역에 페인트를 다시 칠해야 합니다.
롤러의 길이가 4미터이므로 한 번의 페인트칠에 연속된 4개의 구역을 칠할 수 있고 1, 2, 3, 4번 영역에 페인트칠을 하면 한 번에 1, 3번 영역을 모두 칠할 수 있습니다.
따라서 최소 횟수인 1을 return 합니다.

입출력 예 #3

예제 3번은 모든 구역에 페인트칠을 해야 합니다. 롤러의 길이가 1미터이므로 한 번에 한 구역밖에 칠할 수 없습니다.
구역이 4개이므로 각 구역을 한 번씩만 칠하는 4번이 최소 횟수가 됩니다.
따라서 4를 return 합니다.
* */

public class OverDrawing {
    public static int solution(int n, int m, int[] section) {
        int answer = 0;
        // 현재까지 페인트가 칠해진 마지막 구역
        int paintedEnd = 0;
        for (int current : section) {
            // 현재 구역이 이미 칠해져 있다면 넘어감.
            if (current <= paintedEnd) continue;
            // 아직 안 칠해져 있다면 롤러 칠하기.
            answer++;
            // current부터 m칸을 칠하므로 마지막 구역은 current + m - 1
            paintedEnd = current + m - 1;
        }
        return answer;
    }

    public static void main(String[] args) {
        int result = solution(8,4, new int[]{2,3,6});
        System.out.print("첫번째 결과 : ");
        if (result == 2) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }

        result = solution(5,4,new int[]{1,3});
        System.out.print("두번째 결과 : ");
        if (result == 1) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }

        result = solution(4,1,new int[]{1,2,3,4});
        System.out.print("세번째 결과 : ");
        if (result == 4) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}
