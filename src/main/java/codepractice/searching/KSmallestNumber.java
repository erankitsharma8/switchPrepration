package codepractice.searching;

import java.util.PriorityQueue;

public class KSmallestNumber {

    public static void main(String[] args) {
        int []arr={3,4,1,2,6,7};
        int k=3;
        kthSmallestNum(arr,k);
    }

    private static void kthSmallestNum(int[] arr, int k) {
        // max heap
        PriorityQueue<Integer> queue=new PriorityQueue<>();
        for(int n:arr){
            queue.add(n);
            if(queue.size()>k)
                queue.poll();
        }
        System.out.println(queue.peek());


    }
}
