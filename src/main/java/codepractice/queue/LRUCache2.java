package codepractice.queue;

import java.util.HashMap;
import java.util.Map;

public class LRUCache2 {

    private class Node{
        Node prev,next;
        int key,value;
        public Node(int k,int v){
              this.key=k;
              this.value=v;
        }
    }

    Node head,tail;
    Map<Integer,Node> cacheMap;
    int capacity;

    public LRUCache2(int capacity){
        this.capacity=capacity;
        cacheMap=new HashMap<>();
        head=new Node(0,0);
        tail=new Node(0,0);
        head.next=tail;
        head.prev=null;
        tail.prev=head;
        tail.next=null;
    }

    public int get(int key){
        if(!cacheMap.containsKey(key)){
            return -1;
        }
        Node node=cacheMap.get(key);
        removeNode(node);
        insertToFront(node);
        return node.value;
    }

    public void put(int k,int v){
        if(cacheMap.containsKey(k)){
            Node n=new Node(k,v);
            cacheMap.put(k,n);
            removeNode(n);
            insertToFront(n);
        }else{
            Node n=new Node(k,v);
            cacheMap.put(k,n);
            insertToFront(n);
            if(cacheMap.size()>capacity){
                removeNode(tail);
            }
        }
    }

    private void removeNode(Node n){
        n.prev.next=n.next;
        n.next.prev=n.prev;
        n.next=null;
        n.prev=null;
    }

    private void insertToFront(Node n){
        n.next=head.next;
        head.next.prev=n;
        n.prev=null;
        head=n;
    }

    public static void main(String[] args) {
        LRUCache2 lruCache2=new LRUCache2(3);

    }
}
