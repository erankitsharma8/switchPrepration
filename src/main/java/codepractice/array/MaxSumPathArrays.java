package codepractice.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxSumPathArrays {
    private static int maxPathSum(List<Integer> arr1, List<Integer> arr2) {
        // code here
        int res=0;
        int sum1=0,sum2=0;
        int n=arr1.size();
        int m=arr2.size();
        int i=0,j=0;
        while(i<n && j<m){
            if(arr1.get(i)==arr2.get(j)){
                res+=Math.max(sum1,sum2);
                res+=arr1.get(i);
                sum1=0;
                sum2=0;
                i++;
                j++;
            }
            while(i<n && arr1.get(i)<arr2.get(j)){
                sum1+=arr1.get(i);
                i++;
            }
            while(j<m && arr1.get(i)>arr2.get(j)){
                sum2+=arr2.get(j);
                j++;
            }
        }

        while(i<n){
            sum1+=arr1.get(i);
            i++;
        }

        while(j<m){
            sum2+=arr2.get(j);
            j++;
        }

        res+=Math.max(sum1,sum2);

        return res;
    }

    public static void main(String[] args) {
        List<Integer> arr1 = new ArrayList<>(Arrays.asList(2, 3, 7, 10, 12));
        List<Integer> arr2=new ArrayList<>(Arrays.asList(1, 5, 7, 8));
        System.out.println(maxPathSum(arr1,arr2));
    }
}
