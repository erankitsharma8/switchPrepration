package designpattern.strategy;

import designpattern.strategy.drive.SpecialDrive;

public class OffroadVehicle extends Vehicle{

    OffroadVehicle(){
        super(new SpecialDrive());
    }
}
