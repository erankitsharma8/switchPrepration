package sortingandsearching;

public class QuickSort {

    static int arr[]={2,6,1,8,3,9,4,5,Integer.MAX_VALUE};

    //swap
    private static void swap(int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    //partition
    private static int partition(int l,int h){
        int pivote=arr[l];
        int i=l,j=h;
        while(i<j){
            do{
                i++;
            }while(arr[i]<=pivote);
        do{
            j--;
        }while (arr[j]>pivote);
        if(i<j)
        swap(i,j);
        }
        swap(l,j);
        return j;
    }

    //quickSort
    private static void quickSort(int l,int h){
        if(l<h){
            int j=partition(l,h);
            quickSort(l,j);
            quickSort(j+1,h);
        }
    }


    // print array
    private static void print(int [] arr){
        for(int i:arr)
            System.out.print(i+" ");

        System.out.println(" ");
    }

    // main method driver code
    public static void main(String[] args) {
        print(arr);
        int l=0,h=arr.length-1;
        quickSort(l,h);
        print(arr);
    }
}
