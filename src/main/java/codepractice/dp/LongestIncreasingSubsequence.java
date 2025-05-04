package codepractice.dp;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    private static int longestIncreasingSubsequence(int [] arr){
           int n=arr.length;
           int [] dp=new int[n];
           Arrays.fill(dp,1);
           for(int i=1;i<n;i++) {
               int j = 0;
               while (j < i) {
                   if (arr[j] < arr[i] && dp[j] >= dp[i])
                       dp[i] = dp[j] + 1;
                   j++;
               }
           }
               int max=1;
               for(int num:dp)
                   max=Math.max(max,num);
               return max;
    }
    public static void main(String[] args) {
              int [] arr=new int[]{0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
              System.out.println("answer is: "+longestIncreasingSubsequence(arr));
    }
}
