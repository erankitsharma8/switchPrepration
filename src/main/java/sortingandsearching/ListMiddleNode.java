package sortingandsearching;

class Node{
    int data;
    Node next;

    public Node(int data){
        this.data=data;
        this.next=null;
    }
}
public class ListMiddleNode {

    static Node deleteMiddleElement(Node h){
        Node p1= h ,p2=h,p3=h;
        while(p3.next!=null && p3.next.next!=null){
            p1=p2;
            p2=p2.next;
            p3=p3.next.next;
        }
        p1.next=p2.next;
        p2.next=null;
        return h;
    }

    static void printList(Node h){
        while(h.next!=null) {
            System.out.print(h.data);
            h=h.next;
        }

        System.out.println("");
    }

    public static void main(String[] args) {
        Node n=new Node(1);
        Node n1=new Node(2);
        n.next=n1;
        Node n2=new Node(3);
        n1.next=n2;
        Node n3=new Node(4);
        n2.next=n3;
        Node n4=new Node(5);
        n3.next=n4;
        Node n5=new Node(6);
        n4.next=n5;

        Node head=n;
        //print list
        printList(head);

        //delete middle element
        Node head_here=deleteMiddleElement(head);

        //print list
        printList(head_here);
    }


}
