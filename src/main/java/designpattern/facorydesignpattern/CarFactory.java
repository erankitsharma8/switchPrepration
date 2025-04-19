package designpattern.facorydesignpattern;

public class CarFactory implements VehicleFactory{
    @Override
    public Vehicle createVehicle() {
        return new Car();
    }
}
