package interviewcode;

/*
3,4,5,7,9,2,10,11,13,12
9
3,4,5,7,9,2,10,11,12,13
3,4,5,7,9,2,1

 arr= 3,4,5,7,9,1,2
 ele= 9


 */

public class BinarySearchOnRotatedArray {

    private static int rotatedArraySearch(int []arr,int ele){
        int left=0;
        int right=arr.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(arr[mid]==ele)
                return mid;

            if(arr[left]<=arr[mid]){
                if(arr[left]<=ele && ele<arr[mid]){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }else{
                if(arr[mid]<ele && ele<=arr[right]){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] arr={33, 42, 72, 99};
        System.out.println("Result is : " +rotatedArraySearch(arr,42));
    }
}
