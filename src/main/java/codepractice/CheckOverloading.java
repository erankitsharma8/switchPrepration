package codepractice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckOverloading {

    public int PrintList(List<String> ll){
        return 1;
    }

   /* public int PrintList(List<Integer> la){
        return 2;
    }*/
    public static void main(String[] args) {
        CheckOverloading obj=new CheckOverloading();
        List<String> l=null;
        obj.PrintList(l);

        Map<Integer,Integer> hm=new HashMap<>();
        Integer i=hm.put(1,1);
        Integer j=hm.put(1,1);
        System.out.println(i);
        System.out.println(j);
        System.out.println(hm.put(2,2));

    }
}
