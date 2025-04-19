package codepractice.searching;

public class FindNonRepeating {

    public static int search(int n, int arr[]) {
        // your code here
        int l=0,r=n-1;
        boolean flag=true;
        while(l<r){
            int m=l+(r-l)/2;
            if(arr[m]!=arr[m-1] && arr[m]!=arr[m+1]) {
                System.out.println("Return value: " + arr[m] + " m is: " + m);
                return arr[m];
            }
            if((m%2==0 && arr[m]==arr[m+1]) || (m%2==1 && arr[m]==arr[m-1]))
                l=m+1;
            else
                r=m-1;

        }
        if(arr[l]!=arr[l+1] && arr[l]!=arr[l-1]) {
            System.out.println("Return value:: "+arr[l]+" l is: "+l);
            return arr[l];
        }
        System.out.println("Return value::: "+arr[r]+" r is: "+r);
        return arr[r];
    }

    public static void main(String[] args) {
        int [] arr={5,5,8,8,11,11,12,12,14,14,24,27,27,28,28,31,31,45,45};
        System.out.println(search(19,arr));
    }
}
