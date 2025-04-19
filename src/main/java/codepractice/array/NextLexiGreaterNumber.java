package codepractice.array;

public class NextLexiGreaterNumber {

   private static  int[] nextPermutation(int[] arr) {
        int n=arr.length;
        int j=0;
        for(int i=n-1;i>0;i--){
            j=i-1;
            while(j>=0 && arr[j]>arr[i]){
                j--;
            }
            if(j>-1){
                swap(i,j,arr);
                break;
            }
        }
        reverse(j+1,n-1,arr);
        return arr;
    }

    static void swap(int i, int j, int[] arr){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    static void reverse(int i, int j, int[] arr){
        while(i<j){
            swap(i,j,arr);
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
       int [] arr= {2, 4, 1, 7, 5, 0};
        for(int a:arr)System.out.print(a+" ");
        System.out.println(" ");
      arr=nextPermutation(arr);
      for(int a:arr)System.out.print(a+" ");
    }
}
