/*
* 이진트리 순회(깊이우선탐색)
아래 그림과 같은 이진트리를 전위순회와 후위순회를 연습해보세요.

            1
           / \
          /   \
         2     3
        /\     /\
       /  \   /  \
      4    5 6    7

전위순회 출력(부-왼-오) : 1 2 4 5 3 6 7
중위순회 출력(왼-부-오) : 4 2 5 1 6 3 7
후위순회 출력(왼-오-부) : 4 5 2 6 7 3 1
*
* */

package com.company.algorithm.recursive$Tree$DFS$BFS.twoMinuteTree3;

import java.util.Scanner;
    class Node{
        int data;
        Node lt,rt;
        public Node(int data) {
            this.data = data;
            this.lt = rt = null;
        }
    }

public class Main {
    Node tree;
    private static void DFS(Node n){
        if(n == null) return;
        else{
            System.out.print(n.data+ " ");
            DFS(n.lt);
            DFS(n.rt);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main m = new Main();
        m.tree = new Node(1);
        m.tree.lt = new Node(2);
        m.tree.rt = new Node(3);
        m.tree.lt.lt = new Node(4);
        m.tree.lt.rt = new Node(5);
        m.tree.rt.lt = new Node(6);
        m.tree.rt.rt = new Node(7);

        DFS(m.tree);

    }


}
