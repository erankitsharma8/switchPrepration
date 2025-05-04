package codepractice.array;

import java.util.Arrays;

public class MinPlatformRequired {
    private static int findPlatform(int [] arr, int [] dep) {
        int minPlat=1;
        Arrays.sort(arr);
        Arrays.sort(dep);
        int n=arr.length;
        int lastDep=0;
        int count=1;
        int nextArr=1;
        while(nextArr<n){
            if(arr[nextArr]<=dep[lastDep]){
                count++;
                nextArr++;
            }else{
                lastDep++;
                nextArr=lastDep+1;
                minPlat=Math.max(count,minPlat);
                count=1;
            }
        }
        return Math.max(count,minPlat);
    }
    public static void main(String[] args) {
        int []arr = new int [] {900, 940, 950, 1100, 1500, 1800};
        int [] dep = new int[] {910, 1200, 1120, 1130, 1900, 2000};
        System.out.println(findPlatform(arr,dep));
    }
}
