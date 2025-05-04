package codepractice.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordBreak {

    private static boolean wordBreak(String s, String[] dictionary) {
        // code here
        Set<String> dicSet = new HashSet<>(Arrays.asList(dictionary));
        int n=s.length();
        int maxLen=0;
        for(String ss:dictionary)
            maxLen=Math.max(maxLen,ss.length());

        boolean [] dp=new boolean[n+1];
        dp[0]=true;
        for(int i=1;i<=n;i++){
            for(int j=i-1;j>=Math.max(0,i-maxLen);j--){
                if(dp[j] && dicSet.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        String s="ilike";
        String [] str=new String[]{"i","like","gfg"};
        System.out.println("answer is: "+ wordBreak(s,str));
    }
}
