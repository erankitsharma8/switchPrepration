package codepractice.array;

import java.util.Arrays;

public class NumberOfMaxMeetingInOneMeetingRoom {

    private static int maxMeetings(int start[], int end[]) {
        // add your code here
        int n=start.length;
        int [][] meeting=new int[n][2];
        for(int i=0;i<n;i++){
            meeting[i][0]=start[i];
            meeting[i][1]=end[i];
        }
        Arrays.sort(meeting,(a, b)->a[1]-b[1]);

        int maxMeet=1;
        int nextStart=1,currentEnd=0;

        while(nextStart<n){
            while(nextStart<n && meeting[nextStart][0]<=meeting[currentEnd][1]){
                nextStart++;
            }
            if(nextStart<n){
                maxMeet++;
                currentEnd=nextStart;
            }
            nextStart++;
        }
        return maxMeet;

    }

    public static void main(String[] args) {
           int [] start=new int[]{1, 3, 0, 5, 8, 5};
           int [] end=new int[]{2, 4, 6, 7, 9, 9};
           System.out.println(maxMeetings(start,end));
    }
}
