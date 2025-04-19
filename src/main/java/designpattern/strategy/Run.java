package designpattern.strategy;

public class Run {
    public static void main(String[] args) {
        Vehicle vehicle=new GoodVehicle();
        vehicle.drive();
    }
}
