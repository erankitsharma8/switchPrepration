package designpattern.facorydesignpattern;

public class VehicleClient {
    public static void main(String [] args){
        VehicleFactory car=new CarFactory();
        Vehicle c= car.createVehicle();
        c.typeVehicle();
        VehicleFactory bike=new BikeFactory();
        Vehicle b=bike.createVehicle();
        b.typeVehicle();
    }
}
