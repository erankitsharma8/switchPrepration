package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxStrength {

    private static void maxStrength(List<Integer> ll){
        int sum=0;
        for (int i=0;i<ll.size();i++){
            System.out.println("element is: "+ll.get(i));
            sum+=ll.get(i)*(i+1);
        }
        System.out.println("Max sum is: "+sum);
    }

    private static void strength(List<Integer> ll){
        maxStrength(ll);
        for(int i=0;i<ll.size()-1;i++){
            if(ll.get(i)>ll.get(i+1)){
                Collections.swap(ll,i,i+1);
                i++;
            }
        }
        maxStrength(ll);
    }

    public static void main(String[] args) {
        List<Integer> ll=new ArrayList<>();
        ll.add(2);
        ll.add(1);
        ll.add(4);
        ll.add(3);
        //ll.add(4);
        strength(ll);
    }
}
