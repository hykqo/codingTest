/*
* Tree 말단 노드까지의 가장 짧은 경로
*
* 아래 그림과 같은 이진트리에서 루트 노트 1에서 말단노드까지의 길이중 가낭 짧은 길이를 구하는 프로그램을 작성하세요.
* 각 경로의 길이는 루트노트에서 말단노트까지 가는데 이동하는 횟수를 즉 간선(에지)의 개수를 길이로 하겠습니다.
*
            1
           / \
          /   \
         2     3
        /\
       /  \
      4    5

* 가장 짧은 길이는 3번 노트까지의 길이인 1이다.
*
*
* */

package com.company.algorithm.rc$DFS$BFS.DFS$TreeBestRoad3;

class Node{
    int data;
    Node lt, rt;

    public Node(int data) {
        this.data = data;
        lt=rt=null;
    }
}

public class Main {
    Node tree;
    int res = Integer.MAX_VALUE;
    void DFS(Node n, int L){
        if(n.lt == null || n.rt == null && res > L) res = L;
        if(n.lt != null) DFS(n.lt, L+1);
        if(n.rt != null) DFS(n.rt, L+1);
    }

    public static void main(String[] args) {
        Main m =new Main();
        m.tree = new Node(1);
        m.tree.lt = new Node(2);
        m.tree.rt = new Node(3);
        m.tree.lt.lt = new Node(4);
        m.tree.lt.rt = new Node(5);
        m.DFS(m.tree,1);
        System.out.println(m.res);
    }
}
