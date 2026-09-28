package prorammers.level2;

public class MonotonicStatck2 {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];

        int thisIdx = 0;
        while (thisIdx < numbers.length) {
            int current = numbers[thisIdx];
            int nextIdx = thisIdx+1;
            while (true){
                //범위 벗어날경우 -1
                if (nextIdx == numbers.length) {
                    answer[thisIdx] = -1;
                    break;
                }
                int next = numbers[nextIdx];
                if (current < next) {
                    answer[thisIdx] = next;
                    break;
                } else{
                    nextIdx++;
                }
            }
            thisIdx++;
        }
        return answer;
    }

    public static void main(String[] args) {
        MonotonicStatck2 ms = new MonotonicStatck2();
        int[] numbers = {2, 3, 3, 5};
        int[] result = ms.solution(numbers);

        int[] numbers2 = {9, 1, 5, 3, 6, 2};
        int[] result2 = ms.solution(numbers2);

        for (int res : result) {
            System.out.println(res);
        }
        System.out.println("==================");
        for (int res : result2) {
            System.out.println(res);
        }
    }
}
