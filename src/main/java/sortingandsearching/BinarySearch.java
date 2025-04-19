package sortingandsearching;

public class BinarySearch {

    private static void search(int [] arr,int ele){
        int l=0,r=arr.length-1;
        while(l<=r){
           int m=l+(r-l)/2;
            if(arr[m]==ele){
                System.out.println("Found the element at: "+m);
                return;
            }else if(arr[m]<ele){
                l=m+1;
            }else{
                r=m-1;
            }
        }
        System.out.println("Element not found");
    }

    public static void main(String[] args) {
        int [] arr={1,2,3,4,5,6};
        int ele=2;
        search(arr,ele);
    }
}
