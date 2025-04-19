package designpractice.factorypractice;

public class ClientCode {
    public static void main(String[] args) {
        Factory factory=new Factory();
        Vehicle car=factory.createObject("");
        if(null==car){
            System.out.println("Invalid Input!");
        }else {
            car.run();
        }
        Vehicle bike=factory.createObject("Bike");
        if(null==bike){
            System.out.println("Invalid Input!");
        }else {
            bike.run();
        }

    }
}
