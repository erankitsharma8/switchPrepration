package codepractice.array;

public class DutchNationalFlagAlgo {
    private static void sort012(int [] arr){
        if(null== arr || 0==arr.length)
           System.out.println("Invalid input!!");

        int n=arr.length;
        int l=0,m=0,h=n-1;
        while(m<=h){
            if(arr[m]==0){
                swap(arr,l,m);
                l++;
                m++;
            }else if(arr[m]==1){
                m++;
            }else{
                swap(arr,m,h);
                h--;
            }
        }
    }

    private static void swap(int [] arr, int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static void main(String[] args) {
      int [] arr={0, 1, 2, 0, 1, 2};
      for(int n:arr)
          System.out.print(n+" ");
      System.out.println("\nAfter sorting: ");
      sort012(arr);
      for(int n:arr)
            System.out.print(n+" ");
    }
}
