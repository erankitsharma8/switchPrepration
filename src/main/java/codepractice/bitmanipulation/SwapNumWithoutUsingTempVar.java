package codepractice.bitmanipulation;

public class SwapNumWithoutUsingTempVar {
    public static void main(String[] args) {
        int a=1000;
        int b=100;
        System.out.println("Numbers before swap: "+a+" : "+b);
        a^=b;
        b^=a;
        a^=b;
        System.out.println("Numbers after swap: "+a+" : "+b);
    }

}
