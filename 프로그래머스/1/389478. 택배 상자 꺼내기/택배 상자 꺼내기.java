class Solution {
    static int[] boxGIdx, boxFIdx;

    static void setBoxIdx(int n, int w, int num){
        boxGIdx = new int[n+1];
        boxFIdx = new int[n+1];

        //true = left, false = right
        boolean arrow = true;
        int floor = 0;
        //group = 1 ~ w
        int group = 1;
        //박스 쌓기
        for (int i=1; i<=n; i++){
            //박스별 group 인덱스 지정
            boxGIdx[i] = group;
            //박스별 floor 인덱스 지정
            boxFIdx[i] = floor;

            //방향 전환 및 그룹,플로우 초기화 처리.
            if(i%w==0) {
                //방향전환
                arrow = !arrow;
                //전환된 방향이 왼쪽이라면
                if(arrow) group = 1;
                    //전환된 방향이 오른쪽이라면
                else group = w;

                floor++;
            } else{
                if(arrow) group++;
                else group--;
            }
        }
    }

    public static int solution(int n, int w, int num) {
        setBoxIdx(n, w, num);

        int thisGroup = boxGIdx[num];
        int thisFloor = boxFIdx[num];

        //같은 그룹의 1개층 최초 반환 후 종료.
        int answer = 0;
        for (int i=n; i>=num; i--){
            if(boxGIdx[i] == thisGroup) {
                answer = boxFIdx[i] - thisFloor + 1;
                break;
            };
        }
        return answer;
    }
}