package testpackage;

/*
Ask:-
Given two strings s1 and s2. Check if s2 is subsequence of s1.

Ex.:
Input: s1 = INTERVIEWFORSIXT, s2 = REST
s2=FIX

Return : boolean

// Queue all

// Two pointer technique ::

 */

public class StringSubsequence {

    private static boolean checkSubSequence(String s1,String s2){
        if(null==s1 || null==s2)
            return false;

        if(s2.length()>s1.length())
            return false;

        int n=s1.length();
        int m=s2.length();

        if(n==m && s1.equals(s2))
            return true;

        int i=0,j=0;
        while(i<n && j<m){
           if(s1.charAt(i)==s2.charAt(j)){
               j++;
           }
          i++;
        }
        if(j==m)
            return true;
        return false;

    }

    public static void main(String[] args) {
        String s1="INTERVIEWFORSIXT";
        String s2="REST";

        System.out.println("Is s2 a subsequence of s1: "+checkSubSequence(s1,s2));

    }
}
