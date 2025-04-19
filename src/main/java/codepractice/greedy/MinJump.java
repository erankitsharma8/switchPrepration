package codepractice.greedy;

import java.util.ArrayList;
import java.util.List;

public class MinJump {

    private static int minJumps(int [] arr){

        if(null==arr || arr.length==0)
            return -1;
        if(arr.length==1)
            return 0;
        if(arr[0]==0)
            return -1;
        int jump=0;
        int n=arr.length;
        int maxReach=0;
        int currtReach=0;
        for(int i=0;i<n;i++){
            maxReach=Math.max(maxReach,i+arr[i]);

            if(maxReach>=n-1)
                return jump+1;
            if(i==currtReach){
                if(i==maxReach) {
                    return -1;
                }else{
                    jump++;
                    currtReach=maxReach;
                }
            }
        }
      return -1;
    }

    public static void main(String[] args) {
        int [] arr={1, 4, 3, 2, 6, 7};
        System.out.println("Min Jump: "+minJumps(arr));
    }
}
