/*부분집합 구하기(DFS)
*
* 자연수 N이 주어지면 1부터 N까지의 원소를 갖는 집합의 부분집합을 모두 출력하는 프로그램을 작성하세요.
*
* 입력설명
* 첫 번째 줄에 자연수 N(1<=N<=10)이 주어집니다.
*
* 출력설명
* 첫 번째 줄부터 각 줄에 하나씩 부분집합을 아래와 출력예제와 같은 순서로 출력한다.
* 단 공집합(원소가 없는 것)은 출력하지 않습니다.
*
* 입력예제
* 3
*
* 출력예제
* 1 2 3
* 1 2
* 1 3
* 1
* 2 3
* 2
* 3
* */

package com.company.algorithm.recursive$Tree$DFS$BFS.subset;

public class Main {
    static int n;
    //ch[] = 문자 깊이 구분자
    static int[] ch;
    //L = 레벨.
    public void DFS(int L){
        //출력 문자
        String tmp = "";
        //만약 레벨(노드의 깊이)이 허용된 길이를 넘어 섰으면 ex)만약 노드의 깊이가 3레벨일경우 4레벨이 되었다면,
        if(L==n+1){
            //문자 깊이 구분자가 1이라면, 출력문자에 i++;
            for(int i=0; i<=n; i++){
                    if(ch[i]==1) tmp+=(i+" ");
            }
            //만약 출력문자가 있을경우 출력.
            if(tmp.length()>0) System.out.println(tmp);
        //만약 레벨(노드의 깊이)이 적정 레벨 안이라면
        } else {
            //중위순회식으로 처리.
            ch[L] = 1;
            DFS(L+1); //lt
            ch[L] = 0;
            DFS(L+1); //rt
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        n = 3;
        ch = new int[n+1];
        T.DFS(1);
    }
}
