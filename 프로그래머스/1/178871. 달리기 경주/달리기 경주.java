import java.util.HashMap;

class Solution {
        public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> playerIdxMap = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            playerIdxMap.put(players[i], i);
        }

        for (String call : callings) {
            int  playerIdx = playerIdxMap.get(call);
            //이미 1위라면 수행 x
            if(playerIdx == 0) continue;
            int frontIdx = playerIdx-1;

            //순위 변경
            players[playerIdx] = players[frontIdx];
            playerIdxMap.put(players[frontIdx], playerIdx); //map도 최신화

            players[frontIdx] = call;
            playerIdxMap.put(call, frontIdx); //map도 최신화
        }
        return players;
    }
}