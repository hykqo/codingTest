package review1.bfs;


import java.util.LinkedList;
import java.util.Queue;

public class ShortestALeafNode {

    Node root;

    public int DFS(int L, Node root){
        if(root.lt == null && root.rt == null) return L;
        else return Math.min(DFS(L+1, root.lt), DFS(L+1, root.rt));
    }

    public int BFS(Node root){
        int L = 0;
        Queue<Node> Q = new LinkedList<>();
        Q.offer(root);
        while (!Q.isEmpty()){
            int len = Q.size();
            for(int i=0; i<len; i++){
                Node n = Q.poll();
                if(n.lt == null && n.rt == null) return L;
                if(n.lt != null) Q.offer(n.lt);
                if(n.rt != null) Q.offer(n.rt);
            }
            L++;
        }
        return 0;
    }

    public static void main(String[] args) {
        ShortestALeafNode main = new ShortestALeafNode();
        main.root = new Node(1);
        main.root.lt = new Node(2);
        main.root.rt = new Node(3);

        main.root.lt.lt = new Node(4);
        main.root.lt.rt = new Node(5);

        System.out.println(main.DFS(0, main.root));
        System.out.println(main.BFS(main.root));
    }

    public static class Node{
        int data;
        Node lt, rt;

        public Node(int val){
            this.data = val;
            lt = rt = null;
        }
    }
}
