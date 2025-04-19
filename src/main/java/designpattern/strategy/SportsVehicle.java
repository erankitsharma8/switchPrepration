package designpattern.strategy;

import designpattern.strategy.drive.SpecialDrive;

public class SportsVehicle extends Vehicle{
  SportsVehicle(){
      super(new SpecialDrive());
  }
}
