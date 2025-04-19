package codepractice.stack;

import java.util.Stack;

public class SortStackUsingTempStack {

    private static void sortStack(Stack<Integer> st){
        if(null==st || st.isEmpty())
            System.out.println("Invalid Input");

        if(st.size()==1)
            System.out.println(st.peek());

        Stack<Integer> tempStack=new Stack<>();

        while(!st.isEmpty()){
            int temp=st.pop();
            while(!tempStack.empty() && tempStack.peek()<temp){
                st.push(tempStack.pop());
            }
            tempStack.push(temp);
        }
        int top= tempStack.size()-1;
        while(top>=0){
            System.out.print(tempStack.get(top)+" ");
            top--;
        }
    }

    public static void main(String[] args) {
        Stack<Integer> st= new Stack<>();
        st.push(34);
        st.push(3);
        st.push(31);
        st.push(98);
        st.push(92);
        st.push(23);
        int top= st.size()-1;
        while(top>=0){
            System.out.print(st.get(top)+" ");
            top--;
        }
        System.out.println();
        sortStack(st);
    }
}
