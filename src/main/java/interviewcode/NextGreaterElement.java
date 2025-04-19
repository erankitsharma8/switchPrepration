package interviewcode;


/*
Given an array arr[] of integers, the task is to find the Next Greater Element for each element
of the array in order of their appearance in the array.
Input: arr[] = [1, 3, 2, 4]
Output: [3, 4, 4, -1]

 */

import java.util.Stack;

public class NextGreaterElement {

    private static int[] nextGreaterElement(int [] arr) {
          if(null== arr || arr.length==0) {
              System.out.println("Invalid Input!");
            return new int[0];
           }

          int n=arr.length;
          int[] res=new int[n];
          Stack<Integer> st=new Stack<>();

          res[n-1]=-1;

          st.push(arr[n-1]);

          for(int i=n-2;i>=0;i--){

              while(!st.isEmpty() && st.peek()<=arr[i]){
                  st.pop();
              }

              if(!st.empty()) {
                  res[i] = st.peek();
              }else{
                  res[i]=-1;
              }
              st.push(arr[i]);
          }

     return res;

    }

    public static void main(String[] args) {
        int [] arr={1, 1, 2, 3, 4, 2, 1};
        System.out.print("Input array is: ");
        for(int m:arr)
            System.out.print(m+ " ");
        System.out.println(" ");
       arr= nextGreaterElement(arr);

        for(int n:arr)
            System.out.print(n+ " ");

    }



}
