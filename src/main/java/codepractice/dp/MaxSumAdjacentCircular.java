package codepractice.dp;

public class MaxSumAdjacentCircular {

    private static int rob(int[] nums) {
        int n=nums.length;
        if(n==1)
            return nums[0];
        if(n==2)
            return Math.max(nums[0],nums[1]);
        return Math.max(maxNumber(n,0,n-2,nums),maxNumber(n,1,n-1,nums));

    }

    private static int maxNumber(int n,int i,int j,int [] nums){
        int [] dp=new int[n];
        dp[i]=nums[i];
        dp[i+1]=nums[i+1];
        int max=nums[i];
        for(int k=i+2;k<=j;k++){
            dp[k]=max+nums[k];
            max=Math.max(max,dp[k-1]);
        }
        System.out.println("dp is : "+dp[j-1] +": dp is: "+dp[j]+" and j is: "+j);
        return Math.max(dp[j-1],dp[j]);
    }
    public static void main(String[] args) {
        System.out.println(rob(new int []{1,2,3,4,5,1,2,3,4,5}));
    }
}
