/*이진트리 순회 (넓이 우선 탐색 : 레벨탐색) - BFS
출발지점에서 구할 수 있는 최단거리를 구할때 필요하다.
*
* 아래 그림과 같은 이진트리를 레벨탐색 연습하세요.
*
            1
           / \
          /   \
         2     3
        /\     /\
       /  \   /  \
      4    5 6    7

[레벨탐색이란 ? ] - 레벨탐색은 Q를 사용함.
* 루트에서 n레벨 만에 갈 수 있는 노드들 전부 방문.
* 1레벨 = 1
* 2레벨 = 2 3
* 3레벨 = 4 5 6 7
* */

package com.company.algorithm.recursive$Tree$DFS$BFS.twoMinuteLevel4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node{
    int data;
    Node lt, rt;

    public Node(int data) {
        this.data = data;
        lt = rt = null;
    }
}

public class Main {
    Node tree;
    void BFS(Node root){
        Queue<Node> Q = new LinkedList();
        Q.offer(root);
        int L = 0;
        while (!Q.isEmpty()){
            int len = Q.size();
            System.out.println("L : ");
            for(int i=0; i<len; i++){
                Node cur = Q.poll();
                System.out.print(cur.data+" ");
                if(cur.lt != null) Q.offer(cur.lt);
                if(cur.rt != null) Q.offer(cur.rt);
            }
            L++;
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.tree = new Node(1);
        m.tree.lt = new Node(2);
        m.tree.rt = new Node(3);
        m.tree.lt.lt = new Node(4);
        m.tree.lt.rt = new Node(5);
        m.tree.rt.lt = new Node(6);
        m.tree.rt.rt = new Node(7);
        m.BFS(m.tree);
    }

}
