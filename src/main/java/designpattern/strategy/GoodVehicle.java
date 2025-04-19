package designpattern.strategy;

import designpattern.strategy.drive.NormalDrive;

public class GoodVehicle extends Vehicle {

    GoodVehicle(){
        super(new NormalDrive());
    }
}
