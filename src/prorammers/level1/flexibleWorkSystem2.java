package prorammers.level1;

import java.util.Scanner;

/*
n
schedules
timelogs
startday
result

3

700 800 1100

710 2359 1050 700 650 631 659
800 801 805 800 759 810 809
1105 1001 1002 600 1059 1001 1100

5

3

* */
public class flexibleWorkSystem2 {



    public static void main(String[] args) {
        int hourTime = 659;
        int suspendTime = 10;
        System.out.println(Integer.toString(hourTime));

        int hour = hourTime / 100;
        int min = hourTime % 100;

        min = min + suspendTime;

        if(min >= 60){
            hour += min / 60;
            min = min % 60;
        }
        int suspendWorkTime = hour * 100 + min;

        System.out.println(suspendWorkTime);
    }
}
