package designpattern.strategy.drive;

import designpattern.strategy.drive.DriveStrategy;

public class NormalDrive implements DriveStrategy {

    @Override
    public void drive() {
        System.out.println("This is normal drive");
    }
}
