package review1.bfs;

import java.util.LinkedList;
import java.util.Queue;

class Node{
    int data;
    Node lt, rt;

    public Node(int var){
        this.data = var;
        lt = rt = null;
    }
}

public class BinarySearchTree {

    public static void BFS(Node root){
        Queue<Node> Q = new LinkedList<>();
        Q.offer(root);
        int L=0;
        //비어있지 않을때에만 실행
        while(!Q.isEmpty()){
            int len = Q.size();
            System.out.print(L+" : ");
            for(int i=0; i<len; i++){
                Node cur = Q.poll();
                System.out.print(cur.data+ " ");
                if(cur.lt != null) Q.offer(cur.lt);
                if(cur.rt != null) Q.offer(cur.rt);
            }
            L++;
            System.out.println();
        }
    }

    public static void main(String[] args) {
        //0 level
        Node root = new Node(1);
        //1 level
        root.lt = new Node(2);
        root.rt = new Node(3);
        //2 level
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);
        //bfs
        BFS(root);
    }
}
