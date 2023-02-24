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

package com.company.algorithm.rc$DFS$BFS.twoMinuteTree2;
class Node{
    int id;
    Node lt, rt;

    public Node(int id) {
        this.id = id;
        this.lt = rt = null;
    }
}
public class Main {
    Node node;

    public void DFS(Node node){
        if(node==null) return;
        else{
            DFS(node.lt);
            System.out.print(node.id+" ");
            DFS(node.rt);
        }
    }

    public static void main(String[] args) {
        Main tree = new Main();
        tree.node = new Node(1);
        tree.node.lt = new Node(2);
        tree.node.rt = new Node(3);
        tree.node.lt.lt =  new Node(4);
        tree.node.lt.rt = new Node(5);
        tree.node.rt.lt = new Node(6);
        tree.node.rt.rt = new Node(7);

        tree.DFS(tree.node);
    }

}
