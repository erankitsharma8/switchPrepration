package codepractice;

public class Recursion {

    private int sum(int a){
        if(a==1) return 1;

        return a+sum(a-1);
    }

    public static void main(String [] args){
        Recursion r=new Recursion();
        int a=3;
        System.out.println("The sum of the two numbers is: "+r.sum(a));
    }
}
