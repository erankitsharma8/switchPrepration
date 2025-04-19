package sortingandsearching;

import java.util.Arrays;
import java.util.Comparator;



public class ComparatorEx {

    private static void largestNum(int [] nums){
        String [] numStr=new String[nums.length];
        for(int i=0;i<nums.length;i++){
            numStr[i]=String.valueOf(nums[i]);
        }
        Arrays.sort(numStr, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String order1=a+b;
                String order2=b+a;
            return order2.compareTo(order1);
            }
        });


    }



    public static void main(String[] args) {
        int [] num={3,30,34,5,9};
        largestNum(num);
    }
}
