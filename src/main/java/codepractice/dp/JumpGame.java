package codepractice.dp;

public class JumpGame {

    private static int jump(int[] nums) {
        if(null==nums || nums.length==0 || nums[0]==0)
            return -1;
        int n=nums.length;
        if(n==1)
            return 0;
        if(n==2 && nums[0]>0)
            return 1;
        int jump=0;
        int tar=n-1;
        while(tar>0){
            int i=tar-1;
            while(i>=0){
                if(nums[i]+i>=tar)
                    tar=i;
                i--;
            }
            jump++;
        }
        return jump;
    }

    public static void main(String[] args) {
             int [] nums=new int[]{2,3,1,1,4};

    }
}
