package testpackage;

import java.util.Stack;

public class CompareStrings {

    public static void main(String[] args) {
      String s = "ab##", t = "ad##";
        if(createStringWithoutHash(s).equals(createStringWithoutHash(t))){
            System.out.println("True");
        }else{
            System.out.println("False");
        }
    }

    private static String createStringWithoutHash(String s) {
        Stack<Character> st=new Stack<>();
        for(char ch: s.toCharArray()){
            if(ch=='#'){
                if(!st.empty()){
                    st.pop();
                }
            }else{
                st.push(ch);
            }
        }
       return String.valueOf(st);
    }
}
