package testpackage;

public class FibonnicSeries {

    // 0 1 1 2 3 5 8 13 21....

    private static void printNumberInSeries(int num){
        int i=0,j=1;
        if(num<1)
            System.out.println("Incorrect value");

        if(num== 1)
            System.out.println(0);
        if(num==2)
            System.out.println(1);

        num=num-2;
        int sum=0;
        while(num>0){
            sum=i+j;
            i=j;
            j=sum;
            num--;
        }
        System.out.println(sum);


    }

    public static void main(String[] args) {
        int n=8;
        printNumberInSeries(n);
    }
}
