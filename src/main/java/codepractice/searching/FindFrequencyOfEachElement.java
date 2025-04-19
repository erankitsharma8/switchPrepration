package codepractice.searching;

public class FindFrequencyOfEachElement {


    private static void frequencyOfEachElement(int [] arr){
        int n = arr.length;

        int i = 0;

        while (i < n) {
            int val = arr[i];
            int s = i, e = n - 1;
            int endIndex = i;

            while (s <= e) {
                int mid = s + (e - s) / 2;
                if (arr[mid] == val) {
                    endIndex = mid;
                    s = mid + 1;
                }
                else {
                    e = mid - 1;
                }
            }

            int cnt = endIndex - i + 1;

            System.out.println(val + " " + cnt);

            // Set i to next value index
            i = endIndex + 1;
        }


       /* if(null==arr || arr.length==0) {
            System.out.println("Invalid Input!!");
          return;
        }

        if(arr.length==1) {
            System.out.println("Frequency of " + arr[0] + ": " + 1);
            return;
        }
        int n=arr.length;
        int l=0;

        while(l<n) {
            int ele=arr[l];
            int firstAppearance = findFirstAppearance(ele, arr);
            int lastAppearance = findLastAppearance(ele, arr);
            int freq = lastAppearance - firstAppearance + 1;
            System.out.print(" Frequency of " + ele + " is: " + freq);
            l = lastAppearance + 1;
        }*/
    }

  /*  private static int findLastAppearance(int ele, int[] arr) {
        int res=-1;
        int l=0,h=arr.length-1;
        while(l<=h){
            int m=l+(h-l)/2;
            if(arr[m]==arr[l]){
                res=m;
                l=m+1;
            }else if(arr[m]>ele){
                h=m-1;
            }else{
                l=m+1;
            }
        }
        return res;
    }

    private static int findFirstAppearance(int ele, int[] arr) {
        int res=-1;
        int l=0,h=arr.length-1;
        while(l<=h){
            int m=l+(h-l)/2;
            if(arr[m]==arr[l]){
                res=m;
                h=m-1;
            }else if(arr[m]>ele){
                h=m-1;
            }else{
                l=m+1;
            }
        }
        return res;
    }*/


    public static void main(String[] args) {
        int[] arr={1,1,2,2,3,3,3,4,5,5,6,6,6};
        System.out.println("Current array: ");
        for (int n:arr)
            System.out.print(n+" ");
        System.out.println();
        frequencyOfEachElement(arr);
    }
}
