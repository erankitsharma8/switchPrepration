package codepractice;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashMapKey {
        String name;
        String address;

        HashMapKey(String name,String address){
            this.name=name;
            this.address=address;
        }

        @Override
        public int hashCode(){
            return Objects.hash(name,address);
        }

        @Override
        public boolean equals(Object obj){
            if(this==obj)
                return true;
            if(obj==null || getClass()!=obj.getClass())
                return false;
            HashMapKey hm=(HashMapKey) obj;
            return Objects.equals(name,hm.name) && Objects.equals(address,hm.address);
        }

    public static void main(String[] args) {
        Map<HashMapKey,String> hm=new HashMap<>();
        HashMapKey key=new HashMapKey("Ankit","JPMC");
        hm.put(key,"First");
    }
}
