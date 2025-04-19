package sortingandsearching;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BinarySarchOnUnsortedArray {

    private static class Pair{
        int num;
        int loc;

        private Pair(int num,int loc){
            this.num=num;
            this.loc=loc;
        }
    }

    private static void searchElement(int [] arr,int ele){
        List<Pair> pairList=new ArrayList<>();
        for(int i=0;i<arr.length;i++)
            pairList.add(new Pair(arr[i],i));

        pairList.sort(Comparator.comparingInt(a -> a.num));
        pairList.forEach(p->{
            System.out.println("Pairs: "+p.num+" : "+p.loc);
        });
        binarySearch(pairList,ele);
    }

    private static void binarySearch(List<Pair> pairs,int ele){
        int l=0,r=pairs.size()-1;
        while(l<=r){
            int m=l+(r-l)/2;
            System.out.println("values here m: "+m+" ele: "+ele+" pair: "+pairs.get(m).num+" : "+pairs.get(m).loc);
            if(pairs.get(m).num==ele){
                System.out.println("Found the element at: "+pairs.get(m).loc);
                return;
            }else if(pairs.get(m).num<ele){
                l=m+1;
            }else{
                r=m-1;
            }
        }
        System.out.println("Element not found");
    }


    public static void main(String[] args) {
        int [] arr={2,4,3,1,6,5};
        int ele=5;
        searchElement(arr,ele);
    }
}
