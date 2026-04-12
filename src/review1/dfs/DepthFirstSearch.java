package review1.dfs;

class Node{
    int data;
    Node lt, rt;

    public Node(int val){
        this.data = val;
        lt = rt = null;
    }
}

public class DepthFirstSearch {
    Node root;
    public void PreOrder(Node node){
        if(node == null) return;
        System.out.print(node.data+" ");
        if(node.lt != null) PreOrder(node.lt);
        if(node.rt != null) PreOrder(node.rt);
    }

    public void InOrder(Node node){
        if(node == null) return;
        if(node.lt != null) InOrder(node.lt);
        System.out.print(node.data+" ");
        if(node.rt != null) InOrder(node.rt);
    }

    public void PostOrder(Node node){
        if(node == null) return;
        if(node.lt != null) PostOrder(node.lt);
        if(node.rt != null) PostOrder(node.rt);
        System.out.print(node.data+" ");
    }

    public static void main(String[] args) {
        DepthFirstSearch tree = new DepthFirstSearch();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);

        tree.root.lt.rt = new Node(5);
        tree.root.lt.rt.lt = new Node(8);
        tree.root.lt.rt.rt = new Node(9);

        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);

        System.out.print("preOrder : ");
        tree.PreOrder(tree.root);
        System.out.println("");

        System.out.print("inOrder : ");
        tree.InOrder(tree.root);
        System.out.println("");

        System.out.print("postOrder : ");
        tree.PostOrder(tree.root);
        System.out.println("");
    }
}
