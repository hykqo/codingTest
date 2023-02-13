/*재귀함수(자기자신을 호출하는 함수)
- 재귀함수는 스택을 사용한다.
- 모든 함수는 스택을 사용하면 스택에 프레임이라는 것이 생긴다.
- 1개의 프레임에는 [호출된 함수의 매개변수 정보]와 [함수 안에 선언되는 지역변수 정보], [복귀할 주소] 등등이 기입되어 있다.
- 1개의 스택프레임이 끝나고 밑의 스택프레임으로 돌아가는 것을 백 트래킹이라고 한다.

자연수 N이 입력되면 재귀함수를 이용하여 1부터 N까지를 출력하는 프로그램을 작성하세요.

입력설명
첫번째 줄은 정수 N(3<=N<=10)이 입력된다.

출력설명
첫째줄에 출력한다.

입력예제
3

출력예제
1 2 3

*/

package com.company.algorithm.recursive$Tree$DFS$BFS.recursive$StackFrame;

import java.util.Scanner;

public class Main {
    public void DFS(int n){
        if(n==0) return;
        DFS(n-1);
        System.out.print(n+" "); //1 2 3순으로 호출해야 하기 때문에, 재귀함수가 호출되고 난 다음에 적는다.
        //재귀함수가 특정조건에 부합할때까지 스택에 쌓인 후에,
        //특정 조건에 부합하면 맨 위의 스택이 팝 된다.
        //팝이 되고 나면, 이후 아래 마지막 스택이 재귀함수 밑의 로직이 실행한다.
        //재귀함수 밑의 로직이 전부 실행되면, 아래의 스택을 다시 호출한다.(백 트래킹)
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        T.DFS(n);
    }
}
