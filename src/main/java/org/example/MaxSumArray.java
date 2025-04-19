package org.example;


public class MaxSumArray {
    public static void main(String[] args) {
        int [] arr={1,5,2,7,8};
        int max_here=arr[0],max_sum=arr[0];
        for(int i=1;i<arr.length;i++){
            max_here+=arr[i];
            if(max_sum<max_here)
                max_sum=max_here;

            if(max_here<0)
                max_here=0;

        }
        System.out.println("Max Sum is: "+max_sum);
    }
}