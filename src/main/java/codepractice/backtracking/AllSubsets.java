package codepractice.backtracking;

import java.util.ArrayList;
import java.util.List;

public class AllSubsets {

        private static List<List<Integer>> subsets(int[] nums) {
            if(null==nums || nums.length==0)
                return new ArrayList<>();
          List<List<Integer>> res=new ArrayList<>();
          res.add(new ArrayList<>());
          for(int n:nums){
              int s=res.size();
              for(int i=0;i<s;i++){
                  List<Integer> temp=new ArrayList<>(res.get(i));
                  temp.add(n);
                  res.add(temp);
              }
          }
          return res;
        }

    public static void main(String[] args) {
        int [] arr={1,2,3};
        System.out.println("result is:"+ subsets(arr));
    }

}
