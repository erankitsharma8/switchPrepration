package codepractice.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MaxMeetingInOneRoom {

    private static class Meeting{
        int s;
        int e;
        int ind;
        private Meeting(int i,int j,int ind){
            this.s=i;
            this.e=j;
            this.ind=ind;
        }
    }

    private static ArrayList<Integer> maxMeetings(int N, int[] S, int[] F) {
        Meeting[] meetings=new Meeting[N];
       for(int i=0;i<N;i++){
           Meeting m=new Meeting(S[i],F[i],i+1);
           meetings[i]=m;
       }
       Arrays.sort(meetings,(a,b)->a.e-b.e);
       ArrayList<Integer> res=new ArrayList<>();
       res.add(meetings[0].ind);
       int currentEnd=0;
       int nextStart=1;
       while(nextStart<N){
           while(nextStart<N && meetings[currentEnd].e>=meetings[nextStart].s){
               nextStart++;
           }
           if(nextStart==N)
               break;
           res.add(meetings[nextStart].ind);
           currentEnd=nextStart;
           nextStart++;

       }

      Collections.sort(res);
      return res;
    }

    public static void main(String[] args) {
             int n=6;
             int [] s=new int[]{1,3,0,5,8,5};
             int [] e=new int[]{2,4,6,7,9,9};
             ArrayList<Integer> res=maxMeetings(n,s,e);
             res.forEach(System.out::println);
    }
}
