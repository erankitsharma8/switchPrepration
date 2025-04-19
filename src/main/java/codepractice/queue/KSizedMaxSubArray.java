package codepractice.queue;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class KSizedMaxSubArray {

    public ArrayList<Integer> maxOfSubarrays(int arr[], int k) {
        ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            // Remove elements that are out of the current window
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }
            // Maintain the deque such that the front always contains the index of the maximum element
            while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]) {
                dq.pollLast();
            }
            // Add current element's index to the deque
            dq.offerLast(i);
            // Once the first window is processed, add the maximum for the current window
            if (i >= k - 1) {
                result.add(arr[dq.peekFirst()]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        KSizedMaxSubArray kSizedMaxSubArray=new KSizedMaxSubArray();
        int [] arr={1, 2, 3, 1, 4, 5, 2, 3, 6};
        ArrayList<Integer> arrayList=kSizedMaxSubArray.maxOfSubarrays(arr,3);
        arrayList.forEach(System.out::print);
    }
}
