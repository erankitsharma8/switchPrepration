package designpractice.factorypractice;

import java.lang.invoke.VarHandle;

public class Factory {

    public Vehicle createObject(String name){
        if(null==name || name.isEmpty())
            return null;

        if(name=="Bike"){
            return new Bike();
        } else if (name=="Car") {
            return new Car();
        }
        return null;
    }
}
