package codepractice.dp;

import java.util.Arrays;

public class MemoizationDP {

    private static int checkFibonacciNumber(int [] demo,int n){
        if(n<=1)
            return n;

        if(demo[n]!=-1)
            return demo[n];

        demo[n]=checkFibonacciNumber(demo,n-1)+checkFibonacciNumber(demo,n-2);
        return demo[n];

    }

    private static void findFibonacciNumber(int n){
        int [] demo=new int[n];
        Arrays.fill(demo, -1);
        checkFibonacciNumber(demo,n);

    }

    public static void main(String[] args) {
        int n=5;
        findFibonacciNumber(n);
    }
}
