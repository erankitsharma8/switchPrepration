package codepractice.searching;

import java.util.*;

public class FindTripletWithSumZero {
    private static List<List<Integer>> findTriplets(int [] arr){
        if(null==arr || arr.length==0)
            return null;
        List<List<Integer>> res=new LinkedList<>();
        Map<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<arr.length;i++)
            hm.put(arr[i],i);

        for(int j=0;j<arr.length;j++){
            for(int k=j;k< arr.length;k++){
                int val=-(arr[j]+arr[k]);

                if(hm.containsKey(val)){
                    res.add(Arrays.asList(j,k,hm.get(val)));
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr={0,-1,2,-3,1};
        List<List<Integer>> res=findTriplets(arr);

    }

}
