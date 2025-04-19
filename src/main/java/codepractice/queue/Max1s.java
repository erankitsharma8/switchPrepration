package codepractice.queue;

import java.util.LinkedList;
import java.util.Queue;

public class Max1s {

    public int maxOnes(int arr[], int k) {
        // code here
        Queue<Integer> q=new LinkedList<>();
        int count0=0,max=0;
        for(int i=0;i<arr.length;i++){
            if(count0==k && arr[i]==0){
                max=Math.max(max,q.size());
                while(q.peek()!=0){
                    q.poll();
                }
                q.poll();
                q.add(0);
            }else{
                if(arr[i]==1){
                    q.add(1);
                }else{
                    q.add(0);
                    count0++;
                }
            }
        }
        return Math.max(max,q.size());
    }

    public static void main(String[] args) {

    }
}
