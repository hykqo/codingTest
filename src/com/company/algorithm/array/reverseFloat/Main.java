package com.company.algorithm.array.reverseFloat;



/*
6. 뒤집은 소수
설명
N개의 자연수가 입력되면 각 자연수를 뒤집은 후 그 뒤집은 수가 소수이면 그 소수를 출력하는 프로그램을 작성하세요.
예를 들어 32를 뒤집으면 23이고, 23은 소수이다. 그러면 23을 출력한다. 단 910를 뒤집으면 19로 숫자화 해야 한다.
첫 자리부터의 연속된 0은 무시한다.

입력
첫 줄에 자연수의 개수 N(3<=N<=100)이 주어지고, 그 다음 줄에 N개의 자연수가 주어진다.
각 자연수의 크기는 100,000를 넘지 않는다.

출력
첫 줄에 뒤집은 소수를 출력합니다. 출력순서는 입력된 순서대로 출력합니다.

예시 입력 1
9
32 55 62 20 250 370 200 30 100

예시 출력 1
23 2 73 2 3

풀이
1. 입력받은 문자를 for문으로 돌린다.
2. 각 문자를 뒤집자.
3. 뒤집은 문자가 소수인지 체크하자.
4. 소수가 맞다면 출력하자.
 */
import java.io.*;
import java.util.StringTokenizer;
public class Main {
    public void result(int n, StringTokenizer ast, BufferedWriter bw) throws IOException {
        for(int i=0; i<n; i++){
            //tmp = 입력받은 숫자
            int tmp = Integer.parseInt(ast.nextToken());
            //숫자 뒤집기
            int res = 0;
            while (tmp>0){
                //1의 자리 추출 ex) 32 -> 2
                int t = tmp%10;
                //구한 1의 자리를 res에 역으로 담기 ex) 32 -> for1번 2 -> for2번 23
                res =  res*10 + t;
                //연산이 끝났으면 tmp의 1의 자리를 제거.
                tmp = tmp/10;
            }
            if(isPrime(res)) bw.write(res+" ");
        }
    }
    //소수 검색 기능
    // 소수는 1과 자기자신만을 약수로 가지는 존재이다.
    private boolean isPrime(int num) {
        //1은 소수가 아니다.
        if(num==1) return false;
        //2부터 인입받은 숫자까지 조회해서 약수가 존재하면 소수가 아니다.
        for(int i=2; i<num; i++)
            if(num%i==0)
                return false;
        return true;
    }

    public static void main(String[] args) throws IOException {
        Main m = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        m.result(n, st, bw);
        bw.flush();
        bw.close();
    }
}
