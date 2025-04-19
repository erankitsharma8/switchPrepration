package testpackage;

public class Palindrom {

    private static void findPalindrom(int n){
        int res=0;
        int value=n;
        while(n>0){
            int temp=n%10;
            res=res*10+temp;
            n=n/10;
        }
        if(res==value){
            System.out.println("Palindrom");
        }else{
            System.out.println("Not Palindrom");
        }

    }

    public static void main(String[] args) {
        int num=121;
        findPalindrom(num);
    }
}
