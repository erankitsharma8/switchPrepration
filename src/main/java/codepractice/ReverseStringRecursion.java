package codepractice;

public class ReverseStringRecursion {

    private String reverString(String s,int n){
        if(n==1) return ""+s.charAt(0);

        return reverString(""+s.charAt(n),--n);
    }

    public static void main(String [] args){
        String s="abcd";
        int n=s.length()-1;
        ReverseStringRecursion rs=new ReverseStringRecursion();
        System.out.println("The string is: "+s+" and it's rever is: "+rs.reverString(s,n));

    }
}
