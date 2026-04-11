package review1.bfs;

public class RecursiveFunc {

    public static void DFS(int n){
        if(n == 0) return;
        DFS(n-1);
        System.out.print(n+" ");
    }

    public static void main(String[] args) {
        DFS(3);
    }
}
