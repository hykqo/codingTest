package prorammers.level1;


import java.util.Scanner;

/*
muzi ryan frodo neo
muzi:frodo, muzi:frodo, ryan:muzi, ryan:muzi, ryan:muzi, frodo:muzi, frodo:ryan, neo:muzi



joy brad alessandro conan david
alessandro:brad, alessandro:joy, alessandro:conan, david:alessandro, alessandro:david


3
a b c

6
a b
b a
c a
a c
a c
c a

* */
public class MostGiftReceived {

    public static int solution(String[] friends, String[] gifts) {
        int[][] friendGifts = new int[friends.length][friends.length];
        for (int i=0; i<gifts.length; i++){
            String[] gift = gifts[i].split(" ");
            int sendIdx = getFriendIdx(friends, gift[0]);
            int receiveIdx = getFriendIdx(friends, gift[1]);
            friendGifts[sendIdx][receiveIdx]++;
        }

        //선물지수
        int[] giftIdxCnt = new int[friends.length];
        for (int i=0; i<friends.length; i++){
            int allSendCnt = 0;
            int allReceiveCnt = 0;
            for (int j=0; j<friends.length; j++){
                allSendCnt += friendGifts[i][j];
                allReceiveCnt += friendGifts[j][i];
            }
            giftIdxCnt[i] = allSendCnt - allReceiveCnt;
        }

        int[] result = new int[friends.length];
        for (int i=0; i<friends.length; i++){
            for (int j=i+1; j<friends.length; j++){
                int sendCnt = friendGifts[i][j];
                int receiveCnt = friendGifts[j][i];
                if(sendCnt > receiveCnt) {
                    result[i]++;
                }else if(sendCnt < receiveCnt) {
                    result[j]++;
                } else{
                    if(giftIdxCnt[i] > giftIdxCnt[j]) result[i]++;
                    else if(giftIdxCnt[i] < giftIdxCnt[j]) result[j]++;
                }
            }
        }

        int answer = 0;
        for (int res : result){
            answer = Integer.max(res, answer);
        }
         return answer;
    }

    public static int getFriendIdx(String[] friends, String friend){
        for(int i=0; i<friends.length; i++){
            if(friends[i].equals(friend)) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] friends = scanner.nextLine().split(" ");
        String giftStr = scanner.nextLine();
        String[] gifts = giftStr.replaceAll(" ", "").replaceAll(":", " ").split(",");
        System.out.println(solution(friends, gifts));
    }
}
