package codepractice.stack;

public class NextGreaterNumber {
    private static int[] nextGreaterElements(int[] nums) {
        if(null==nums || nums.length==0)
            return new int[0];
        if(nums.length==1)
            return new int[0];

        int n=nums.length;

        int [] res=new int[n];
        for(int i=0;i<n-1;i++){
            int grt=nums[i+1];
            if(grt>nums[i]){
                res[i]=grt;
            }else{
                int j=i+2;
                while(j<n && nums[j]<=grt){
                    j++;
                }
                if(j==n){
                    res[i]=-1;
                }else{
                    res[i]=nums[j];
                }
            }
        }
        int k=0;
        while(k<n && nums[k]<=nums[n-1]){
            k++;
        }
        if(k==n){
            System.out.println("Here inside k==n : "+k);
            res[n-1]=-1;
        }else{
            System.out.println("In else n-1 is: " +nums[k]);
            res[n-1]=nums[k];
        }
        return res;
    }

    public static void main(String[] args) {
        int [] arr={1};
        arr=nextGreaterElements(arr);
        for(int n:arr){
            System.out.println("next grter num: "+n);
        }
    }
}
