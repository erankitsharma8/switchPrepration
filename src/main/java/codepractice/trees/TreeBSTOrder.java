package codepractice.trees;

class Node{
    int data;
    Node left,right;

     Node(int item){
        this.data=item;
        this.left=this.right=null;
    }
}

public class TreeBSTOrder {

   static void printTree(Node n){
        if(n==null)
            return;

        printTree(n.left);
        System.out.print(n.data);
        printTree(n.right);
    }

    public static void main(String[] args) {
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.left=new Node(6);
        root.right.right=new Node(7);
        printTree(root);

    }
}
