package interviewcode;

/*
Given a string S, find the length of the longest balanced subsequence in it. A balanced string is defined as:-

A null string is a balanced string.
If X and Y are balanced strings, then (X)Y and XY are balanced strings.
S = "()())"
return length of the balanced string.
Ignore space in b/w

 */

import java.util.Stack;

public class ValidString {

    private static int longestBalancedString(String s){

        if(null==s || s.isEmpty())
            return 0;

        Stack<Integer> st=new Stack<>();
        int maxLength=0;
        st.push(-1);

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
                st.push(i);
            }else if(ch==')'){
                st.pop();
                if(!st.isEmpty()){
                    maxLength=Math.max(maxLength,i-st.peek());
                }else{
                    st.push(i);
                }
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        // Ex. 1: ()())
       int n=longestBalancedString("()(((((()");
       System.out.println("The longest Balanced Substring is: "+n);
    }
}
