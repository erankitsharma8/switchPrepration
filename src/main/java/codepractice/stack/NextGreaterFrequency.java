package codepractice.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterFrequency {

    private static void fetchNextGreaterFrequency(int arr[]){
        if(null==arr || arr.length==0)
             System.out.println("Invalid Input");

        int n=arr.length;
        Map<Integer,Integer> frequencyMap=new HashMap<>();
        Stack<Integer> visitedElements=new Stack<>();
        for(int num:arr)
           frequencyMap.merge(num,1,Integer::sum);

        visitedElements.push(arr[n-1]);
        int res[]=new int[n];
        res[n-1]=-1;

        for(int i=n-2;i>=0;i--){
            int currtElement=arr[i];
            int currtFreq=frequencyMap.get(currtElement);
            while(!visitedElements.isEmpty() && currtFreq>=frequencyMap.get(visitedElements.peek())){
               visitedElements.pop();
            }
            if (visitedElements.isEmpty()){
                res[i] = -1;
            }else{
                res[i] = visitedElements.peek();
            }
            visitedElements.push(currtElement);
        }
        for(int r:res)
            System.out.print(r+" ");
    }

    public static void main(String[] args) {
        int arr[]={1, 1, 1, 2, 2, 2, 2, 11, 3, 3};
        for(int s:arr)
            System.out.print(s+" ");

        System.out.println(" ");
        fetchNextGreaterFrequency(arr);
    }
}
