package codepractice.queue;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] arr, int k) {
        int n = arr.length;
        int[] result = new int[n - k + 1];
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
                result[i - k + 1] =arr[dq.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        MaxSlidingWindow mx=new MaxSlidingWindow();
        int [] arr={1,3,-1,-3,5,3,6,7};
        int [] res=mx.maxSlidingWindow(arr,3);
        for(int r:res)
            System.out.println("nums: in arr: "+r);
    }
}
