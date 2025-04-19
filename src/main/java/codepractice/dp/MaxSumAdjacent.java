package codepractice.dp;

public class MaxSumAdjacent {

    private static int maxSumAdjacent(int [] arr){
        int n=arr.length;
        if(n==1)
            return arr[0];
        if(n==2)
            return Math.max(arr[0],arr[1]);
        int [] dp=new int[n];
        dp[0]=arr[0];
        dp[1]=arr[1];
        int max=arr[0];
        for(int i=2;i<n;i++){
            dp[i]=max+arr[i];
            max=Math.max(max,dp[i-1]);
        }
         return Math.max(dp[n-1],dp[n-2]);
    }

    public static void main(String[] args) {
        int [] arr={2,7,9,3,1};
        System.out.println(maxSumAdjacent(arr));
    }

}
