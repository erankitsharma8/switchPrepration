package org.example;

public class Singleton {
    private int number;
    private String name;

    private Singleton singleton;

    private Singleton(int num,String nam){
        Singleton obj=new Singleton();
        obj.number=num;
        obj.name=nam;
    }

    private Singleton() {

    }

    public Singleton getInstance(Singleton singleton){
        if(null!=singleton) {
            return this.singleton;
        }else{
           return new Singleton(singleton.number,singleton.name);
        }
    }
}
