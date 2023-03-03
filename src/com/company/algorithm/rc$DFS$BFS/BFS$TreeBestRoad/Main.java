/*
*
* Tree 말단 노드까지의 가장 짧은 경로(BFS)
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

package com.company.algorithm.rc$DFS$BFS.BFS$TreeBestRoad;

import java.util.LinkedList;
import java.util.Queue;

class Node{
    int data;
    Node lt, rt;

    public Node(int data) {
        this.data = data;
        lt = rt = null;
    }
}

public class Main {
    Node root;
    int BFS(Node node){
        int L = 1;
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        while (!q.isEmpty()){
            int len = q.size();
            for(int i=0; i<len; i++){
                Node n = q.poll();
                if(n.lt != null) q.offer(n.lt);
                if(n.rt != null) q.offer(n.rt);
                if(n.rt == null || n.lt == null) return L;
            }
            L++;

        }
        return 0;
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.root = new Node(1);
        m.root.lt = new Node(2);
        m.root.rt = new Node(3);
        m.root.lt.lt = new Node(4);
        m.root.lt.rt = new Node(5);
        System.out.println(m.BFS(m.root));


    }

}
