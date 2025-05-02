package codepractice.string;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CamelPatternMatch {

    private static List<String> camelCase(String[] arr, String pat) {
        Map<String,List<String>> dictMap=new HashMap<>();
        for(String s:arr){
            StringBuilder res=new StringBuilder();
            for(char c:s.toCharArray()){
                if(Character.isUpperCase(c))
                    res.append(c);
            }
            String result=res.toString();
            if(dictMap.containsKey(result)){
                List<String> value=dictMap.get(result);
                value.add(s);
                dictMap.put(result,value);
            }else{
                List<String> vv=new LinkedList<>();
                vv.add(s);
                dictMap.put(result,vv);
            }
        }
        List<String> ans=new LinkedList<>();
        dictMap.forEach((k,v)->{
            int i=0,j=0;
            int count=pat.length();
            while(i<k.length() && j<pat.length()){
                if(k.charAt(i)==pat.charAt(j)){
                    j++;
                    count--;
                }
                else
                    break;
                i++;
            }
            if(count==0)
                ans.addAll(v);
        });
        return ans;
    }

    public static void main(String[] args) {
        String [] arr= new String []{"WelcomeGeek", "WelcomeToGeeksForGeeks", "GeeksForGeeks"};
        String pat = "WTG";
        List<String> res=camelCase(arr,pat);
        res.forEach(System.out::println);
    }
}
