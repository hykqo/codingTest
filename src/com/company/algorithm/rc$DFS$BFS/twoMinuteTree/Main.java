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

package com.company.algorithm.rc$DFS$BFS.twoMinuteTree;

class Node{
    int data; //자기자신
    Node lt, rt; //왼쪽 노드의 주소, 오른쪽 노드의 주소
    public Node(int val){
        data = val;
        lt=rt=null;
    }

}
public class Main {
    Node root;
    public void DFS(Node root){
        if(root==null) return;//말단 노드인지 체크
        else{
//            System.out.print(root.data+" "); //전위순회
            DFS(root.lt);
//            System.out.print(root.data+" "); //중위순회
            DFS(root.rt);
            System.out.print(root.data+" "); //후위순회
        }
    }
    public static void main(String[] args) {
        //tree set
        Main tree = new Main();
        tree.root=new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        tree.DFS(tree.root);
    }
}
