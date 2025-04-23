package codepractice.array;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals {
    private static int [][] mergeIntervals(int [][]arr){
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        ArrayList<int[]> res=new ArrayList<>();
       int [] current=arr[0];
       res.add(current);
       for(int []a :arr){
           int currentEnd=current[1];
           int nextStart=a[0];
           int nextEnd=a[1];
           if(currentEnd>=nextStart){
               current[1]=Math.max(currentEnd,nextEnd);
           }else{
               current=a;
               res.add(current);
           }
       }
       return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };
        intervals=mergeIntervals(intervals);
        for(int [] inter:intervals)
            System.out.println(inter[0]+","+inter[1]);
    }
}
