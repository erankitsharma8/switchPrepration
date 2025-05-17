package codepractice.trees;


import java.util.LinkedList;
import java.util.Queue;

public class TreeLevelOrder {

    static void printLevelOrder(Node n){
        Queue<Node> q=new LinkedList<>();
        q.add(n);
        int count=0;
        while(!q.isEmpty()){
            count++;
            Node e=q.peek();
            System.out.print(q.poll().data);
            if(e.left!=null)
                q.add(e.left);
            if(e.right!=null)
                q.add(e.right);
        }
    }

    public static void main(String[] args) {
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.left=new Node(6);
        root.right.right=new Node(7);
        printLevelOrder(root);
    }
}
