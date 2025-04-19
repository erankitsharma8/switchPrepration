package codepractice.stack;

import java.util.Stack;

public class StockSpan {

    private static void printStockSpan(int [] arr){
        if(null==arr || arr.length==0)
            System.out.println("Invalid Input");

        if(arr.length==1)
            System.out.println(1);

        int n=arr.length;
        int [] res=new int[n];
        Stack<Integer> st=new Stack<>();
        res[0]=1;
        st.push(0);
        for(int i=1;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]<=arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                res[i]=i+1;
            }else{
                res[i]=i-st.peek();
            }
            st.push(i);
        }

        for(int m:res)
            System.out.print(m+" ");

    }

    public static void main(String[] args) {
        int [] arr={10, 4, 5, 90, 120, 80};
        for(int n:arr)
            System.out.print(n+" ");

        System.out.println();
        printStockSpan(arr);
    }
}
