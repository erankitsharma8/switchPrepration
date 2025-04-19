package codepractice.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MaximalDisjointIntervals {

    private static void maxDisjointIntervals(int[][] arr) {
        Arrays.sort(arr,(a, b)->a[1]-b[1]);
        List<int[]> list=new ArrayList<>();
        int res=1,j=0;
        list.add(arr[0]);
        for(int i=0;i<arr.length;i++){
            if(arr[j][1]<arr[i][0]){
               list.add(arr[i]);
                res++;
                j=i;
            }
        }
        System.out.println("Total is: "+res+" list size: "+ list.size());
        list.forEach(l->{
            System.out.println(l[0]+" :"+l[1]);
        });

    }

    public static void main(String[] args) {
        int [][] arr=new int[4][2];
        arr[0][0]=1;
        arr[0][1]=4;
        arr[1][0]=2;
        arr[1][1]=3;
        arr[2][0]=4;
        arr[2][1]=6;
        arr[3][0]=8;
        arr[3][1]=9;
        maxDisjointIntervals(arr);

    }


}
