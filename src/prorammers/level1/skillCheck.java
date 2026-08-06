package prorammers.level1;

public class skillCheck {

    public boolean solution(String s) {
        char[] cList = s.toCharArray();
        //숫자로만 구성되어 있는지 체크
       if((s.length() == 4 || s.length() == 6) && s.matches("[0-9]+")){
           return true;
       }
        return false;
    }
}
