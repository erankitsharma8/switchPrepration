package codepractice.greedy;

public class JumpPossible {

    public static void main(String[] args) {
        int[] arr={2, 3, 1, 1, 4};
        int lastPos=arr.length-1;
        int currentPos=0;
        for(int i=arr.length-2;i>=0;i--){
            currentPos=arr[i]+i;
            if(currentPos>=lastPos)
                lastPos=i;
        }
        System.out.println(lastPos==0);
      /*  boolean flag=false;
        while(n>0){
            while(i<arr.length) {
                i += n;
                if (i == size) {
                    System.out.println("True");
                    flag=true;
                    break;
                }
            }
            if(flag)
                break;
            n--;
        }
        if(!flag)
            System.out.println("False");*/
    }
}
