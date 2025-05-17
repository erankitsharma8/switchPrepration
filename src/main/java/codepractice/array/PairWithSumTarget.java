package codepractice.array;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PairWithSumTarget {
    private static List<Integer> twoSum(int arr[], int target) {
        Map<Integer,Integer> hm=new HashMap<>();
        for(int a:arr)
            hm.put(a,hm.getOrDefault(a,0)+1);

        List<Integer> res=new LinkedList<>();

        for(int a:arr){
            int num=target-a;
            if(hm.get(a)>1){
                hm.put(a,hm.getOrDefault(a,0)-1);
            }else{
                hm.remove(a);
            }
            if(hm.containsKey(num)){
                res.add(a);
                res.add(num);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int [] arr=new int[]{2,9,10,4,15};
        List<Integer> ans=twoSum(arr,12);
        ans.forEach(System.out::println);
    }
}
