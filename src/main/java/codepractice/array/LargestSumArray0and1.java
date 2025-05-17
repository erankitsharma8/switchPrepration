package codepractice.array;

import java.util.HashMap;
import java.util.Map;

public class LargestSumArray0and1 {

    private static int maxLen(int[] arr) {
        // Your code here
        Map<Integer,Integer> hm=new HashMap<>();
        for(int a:arr)
            hm.put(a,hm.getOrDefault(a,0)+1);

        int l=0,r=arr.length-1;
        while(l<r){
            if(hm.get(0)==hm.get(1))
                return r-l+1;
            if(hm.get(0)>hm.get(1)){
                if(arr[l]==0){
                    hm.put(arr[l],hm.getOrDefault(arr[l],0)-1);
                    l++;
                }
                else{
                    hm.put(arr[r],hm.getOrDefault(arr[r],0)-1);
                    r--;
                }
            }else{
                if(arr[l]==1){
                    hm.put(arr[l],hm.getOrDefault(arr[l],0)-1);
                    l++;
                }
                else{
                    hm.put(arr[r],hm.getOrDefault(arr[r],0)-1);
                    r--;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
       int [] arr = new int[]{1,0,0,0,1,0,0,0,0,0,1,1,1,1,0};
       System.out.println(maxLen(arr));
    }
}
