package sortingandsearching;

public class NumSmallGreater {

    private static int findSmallest(int [] arr){
        int first_ele=arr[0];
        int n=1;
        while(n<arr.length-1){
            if(arr[n]>first_ele){
                first_ele=arr[n];
                int ind=n;
                n++;
                while(n<arr.length-1 && first_ele<arr[n]){
                    n++;
                }
                if(n==arr.length-1)
                    return ind;
                else
                    first_ele=arr[n];
            }else{
                n++;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int [] arr={1, 3, 5, 7, 9, 6};
        int num=findSmallest(arr);
        System.out.println("the Num is: "+num);
    }
}
