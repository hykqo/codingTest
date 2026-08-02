package prorammers.level1;

import java.util.Scanner;

/*
34:33
13:00
00:55
02:55
2
next prev

res = "13:00"



10:55
00:05
00:15
06:55
3
prev next next



07:22
04:05
00:15
04:07
1
next
* */
public class mediaPlayer {

    public static String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int videoSec = getTotSec(video_len);
        int posSec = getTotSec(pos);
        int opStartSec = getTotSec(op_start);
        int opEndSec = getTotSec(op_end);

        for (String command : commands){
            posSec = moveCommand(videoSec, posSec, command, opStartSec, opEndSec);
        }
        return formatTime(posSec);
    }


    public static int moveCommand(int videoSec, int posSec, String command, int opStartSec, int opEndSec){
        int commandPos = getCommandPos(command, posSec);

        //10초후 결과가 범위를 벗어나면 양 끝으로 이동.
        if(commandPos  <  0) commandPos = 0;
        else if(commandPos > videoSec) commandPos = videoSec;

            //현재 위치가 오프닝 구간이면서 next버튼을 클릭했다면 오프닝 끝나는 지점으로 현재 위치를 이동시킨 후에 10초 이동
        else if(opStartSec <= posSec && posSec <= opEndSec && "next".equals(command)) {
            commandPos = getCommandPos(command, opEndSec);
        }
        //이동된 위치가 오프닝 구간이라면 현재 위치를 오프닝 종료구간으로 이동
        else if(opStartSec <= commandPos  && commandPos <= opEndSec) {
            commandPos = opEndSec;
        }

        //아무 조건에 해당이 안될 경우 처음 계산된 시간 반환.
        return commandPos;

    }

    public static int getCommandPos(String command, int posSec){
        if("prev".equals(command)) return posSec - 10;
        else if("next".equals(command)) return posSec + 10;
        else return posSec;
    }

    public static String formatTime(int sec){
        int min = sec / 60;
        int rem = sec % 60;
        return String.format("%02d:%02d", min, rem);
    }


    public static int getTotSec(String minSec){
        String[] split = minSec.split(":");
        int min = Integer.parseInt(split[0]);
        int sec = Integer.parseInt(split[1]);
        int totSec = min * 60 + sec;
        return totSec;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String video_len = scanner.nextLine();
        String pos = scanner.nextLine();
        String op_start = scanner.nextLine();
        String op_end = scanner.nextLine();
        int n = scanner.nextInt();
        String[] commands = new String[n];
        for(int i=0; i<n; i++) commands[i] = scanner.next();

        System.out.println(solution(video_len, pos, op_start, op_end, commands));
    }
}
