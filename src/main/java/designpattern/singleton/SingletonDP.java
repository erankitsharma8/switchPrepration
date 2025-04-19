package designpattern.singleton;

public class SingletonDP {

    public String s;

    private static SingletonDP singletonDP=null;

    private SingletonDP(){
       s="Ankit here";
    }

    public static synchronized SingletonDP getInstance(){
        if(null==singletonDP)
            singletonDP= new SingletonDP();
        return singletonDP;
    }

    public static void main(String[] args) {
        SingletonDP x=SingletonDP.getInstance();
        SingletonDP y=SingletonDP.getInstance();
        System.out.println("hashcode of: x {} & y {}" + x.hashCode()+ " "+ y.hashCode());
    }

}
