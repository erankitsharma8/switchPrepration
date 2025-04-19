package codepractice.array;

public class MostWater {
    private static int maxWater(int arr[]) {
        // Code Here
        int l=0,r=arr.length-1;
        int min=0,max=0;
       while(l<r){
           min=Math.min(arr[l],arr[r]);
           max=Math.max(max,min*(r-l));
           
       }
        return max;
    }
    public static void main(String[] args) {
        int []arr={2, 1, 8, 6, 4, 6, 5, 5};
        System.out.println(maxWater(arr));
    }
}
