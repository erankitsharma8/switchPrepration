package codepractice.dp;

public class BasicFibonociSeries {

    // 0 1 1 2 3 5 8 13 21 ....
    private static int findFibonacciNumber(int n){
        if(n<=1)
            return n;

        return findFibonacciNumber(n-1)+findFibonacciNumber(n-2);
    }

    public static void main(String[] args) {
          int n=5;
        System.out.println(findFibonacciNumber(n));
    }
}
