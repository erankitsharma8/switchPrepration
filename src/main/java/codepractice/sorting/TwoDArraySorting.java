package codepractice.sorting;

import java.util.Arrays;

public class TwoDArraySorting {

    public static void main(String[] args) {
        int [][] arr=new int[4][2];
        arr[0][0]=1;
        arr[0][1]=2;
        arr[1][0]=2;
        arr[1][1]=3;
        arr[2][0]=3;
        arr[2][1]=4;
        arr[3][0]=1;
        arr[3][1]=3;

        System.out.print("Arrays in 2D\n ");
        for(int[] n:arr){
            System.out.print("("+n[0]+","+n[1]+")");
        }
        System.out.println("\n Sorting on Row basis");

        Arrays.sort(arr,(a,b)->b[1]-a[1]);
        for(int[] n:arr){
            System.out.print("("+n[0]+","+n[1]+")");
        }

        System.out.println("\n Sorting on Column basis");

        Arrays.sort(arr,(a,b)->b[0]-a[0]);
        for(int[] n:arr){
            System.out.print("("+n[0]+","+n[1]+")");
        }

    }
}
