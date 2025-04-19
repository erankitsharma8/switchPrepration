package designpractice;

public class Singleton {

    private String str;

    private static Singleton singleton;

    private Singleton(String str){
        this.str=str;
    }

    public  static Singleton getInstance(){
        if(singleton==null){
            singleton=new Singleton("abc");
            return singleton;
        }
        return singleton;
    }


}
