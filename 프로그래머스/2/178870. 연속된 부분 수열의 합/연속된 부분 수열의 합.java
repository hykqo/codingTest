class Solution {
public int[] solution(int[] sequence, int k) {
        int lt = 0;
        int rt = 0;
        int sum = sequence[0];
        int resL = 0;
        int resR = sequence.length - 1;

        while (lt <= rt && rt < sequence.length) {
            if (sum == k) {
                if (rt - lt < resR - resL) {
                    resL = lt;
                    resR = rt;
                }
            }

            if (sum < k) {
                rt++;
                if (rt < sequence.length) {
                    sum += sequence[rt];
                }
            } else {
                sum -= sequence[lt];
                lt++;
            }
        }

        return new int[]{resL, resR};
    }
}