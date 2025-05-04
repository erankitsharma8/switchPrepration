package codepractice.stack;

import java.util.Stack;

public class NearestSmallerNumber {

    private static void fetchNearestSmallerNumber(int[] arr){
        if(null==arr || arr.length==0)
            System.out.println("Invalid Input");
        int n=arr.length;
        Stack<Integer> st=new Stack<>();
        st.push(arr[0]);
        int[] res=new int[n];
        res[0]=-1;
        for(int i=1;i<n;i++){
            while(!st.isEmpty() && arr[i]<=st.peek()){
                st.pop();
            }
            if(st.isEmpty()){
                res[i]=-1;
            }else{
                res[i]=st.peek();
            }
            st.push(arr[i]);

        }
        for(int m:res)
            System.out.print(m+" ");
    }
    public static void main(String[] args) {
        int[] arr ={1, 3, 0, 2, 5};
        for(int a:arr)
            System.out.print(a+" ");
        System.out.println(" ");
        fetchNearestSmallerNumber(arr);
    }
}
