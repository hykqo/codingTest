/*
* 4. Least Recently Used
설명
캐시메모리는 CPU와 주기억장치(DRAM) 사이의 고속의 임시 메모리로서 CPU가 처리할 작업을 저장해 놓았다가
필요할 바로 사용해서 처리속도를 높이는 장치이다. 워낙 비싸고 용량이 작아 효율적으로 사용해야 한다.
철수의 컴퓨터는 캐시메모리 사용 규칙이 LRU 알고리즘을 따른다.
LRU 알고리즘은 Least Recently Used 의 약자로 직역하자면 가장 최근에 사용되지 않은 것 정도의 의미를 가지고 있습니다.
캐시에서 작업을 제거할 때 가장 오랫동안 사용하지 않은 것을 제거하겠다는 알고리즘입니다.

<LRU알고리즘 설명>
* 만약 캐시의 사이즈가 5이고 작업이 23167 순으로 저장되어 있다면,.
(맨 앞이 가장 최근에 쓰인 작업이고, 맨 뒤는 가장 오랫동안 쓰이지 않은 작업이다.)

* 1) Cache Miss : 해야할 작업이 캐시에 없는 상태로 위 상태에서 만약 새로운 작업인 5번 작업을 CPU가 사용한다면 Cache miss가 되고 모든 작업이 뒤로 밀리고
5번 작업은 캐시의 맨 앞에 위치한다. 52316 (7번 작업은 캐시에서 삭제된다)

* 2) Cache Hit : 해야할 작업이 캐시에 있는 상태로 위 상태에서 만약 3번 작업을 CPU가 사용한다면 Cache Hit가 되고, 3번 앞에 있는 5,2번 작업은 한칸 뒤로 밀리고,
3번이 맨 앞으로 위치하게 된다. 52316 --> 35216
*

캐시의 크기가 주어지고, 캐시가 비어있는 상태에서 N개의 작업을 CPU가 차례로 처리한다면 N개의 작업을 처리한 후
캐시메모리의 상태를 가장 최근 사용된 작업부터 차례대로 출력하는 프로그램을 작성하세요.

입력
첫 번째 줄에 캐시의 크기인 S(3<=S<=10)와 작업의 개수 N(5<=N<=1,000)이 입력된다.
두 번째 줄에 N개의 작업번호가 처리순으로 주어진다. 작업번호는 1 ~100 이다.

출력
마지막 작업 후 캐시메모리의 상태를 가장 최근 사용된 작업부터 차례로 출력합니다.


예시 입력 1
5 9
1 2 3 2 6 2 3 7

예시 출력 1
7 5 3 2 6*/
package com.company.algorithm.sorting$Searching.leastRecentlyUsed;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] cache = new int[n];
        //작업 시작
        for(int i=0; i<m; i++) {
            //현재 막 작업이 완료된 job - 저장 대기 상태
            int job = sc.nextInt();

            //캐시메모리를 체크하여 Chche Hit 여부 체크 및 Chche Hit일경우 해당 인덱스 반환.
            int x = n-1;
            for(int c=0; c<cache.length; c++){
                if(cache[c] == job) {
                    x = c;
                }
            }

            //작업 완료된 job을 캐시메모리에 저장.
            for(int j=x; j>0; j--){
                cache[j] = cache[j-1];
            }
            cache[0] = job;
        }
        for(int i : cache) System.out.print(i+" ");
    }
}

