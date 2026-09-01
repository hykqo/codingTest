package prorammers.level2;

import java.util.HashMap;

public class NumberOfServerExpansions {
    public int solution(int[] players, int m, int k) {
        int serverAddCount = 0;
        int accumulateServerAdd = 0;

        //서버 만료시간.
        HashMap<Integer, Integer> serverExpireTime = new HashMap<>();

        //서버 기동
        for (int i=0; i<players.length; i++) {
            //증설된 서버 운영시간 체크 및 서버종료
            if(serverExpireTime.containsKey(i)){
                int expireServerCnt = serverExpireTime.get(i);
                serverExpireTime.remove(i);
                accumulateServerAdd -= expireServerCnt;
            }

            //증설된 서버내에서 처리가능한 동접자인지 체크.
            int requireServer = players[i] / m;
            if(accumulateServerAdd < requireServer){
                int addServerCount = requireServer - accumulateServerAdd;
                serverExpireTime.put(i+k, addServerCount);
                accumulateServerAdd += addServerCount;
                serverAddCount += addServerCount;
            }
        }

        return serverAddCount;
    }



}
