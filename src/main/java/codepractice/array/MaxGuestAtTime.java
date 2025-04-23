package codepractice.array;

import java.util.Arrays;

public class MaxGuestAtTime {
    private static int[] findMaxGuests(int[] entry,int exit[], int n){
        Arrays.sort(entry);
        Arrays.sort(exit);
        int [] res=new int[2];
        int i=0,j=0;
        int count=0,max=0;

        while(i<n && j<n){
            if(entry[i]<=exit[j]){
                count++;
                if(count>max){
                    max=count;
                    res[1]=entry[i];
                }
                i++;
            }else{
                count--;
                j++;
            }
        }
        res[0]=max;
        return res;
    }

    public static void main(String[] args) {
        int [] entry=new int[]{1, 2,10, 5, 5};
        int [] exit=new int[]{4, 5, 12, 9, 12};
        int n=5;
        int [] res=findMaxGuests(entry,exit,n);
        System.out.println("res: "+res[0]+","+res[1]);
    }
}
