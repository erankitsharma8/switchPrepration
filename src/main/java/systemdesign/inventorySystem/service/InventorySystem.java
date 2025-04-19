package systemdesign.inventorySystem.service;

import systemdesign.inventorySystem.model.Transporter;
import systemdesign.inventorySystem.model.User;
import systemdesign.inventorySystem.constants.Containers;
import systemdesign.inventorySystem.utils.DistanceCalculationUtility;

import java.util.List;

public class InventorySystem {

    Transporter transporter;

    User user;

    DistanceCalculationUtility distanceCalculationUtility;

    double totalDistance;

    public InventorySystem(Transporter transporter,User user){
     this.transporter=transporter;
     this.user=user;
    }

    public double containerCharges(){
        List<Containers> containers=this.user.getContainers();
        double price=0;
        for(Containers container: containers) {
            price += container.getPrice();
        }
        return price;
    }

    public double shippingCost(double containerCharge){
        this.distanceCalculationUtility=new DistanceCalculationUtility(this.user.getFrom(),this.user.getTo());
        double totalDistance=distanceCalculationUtility.totalDistance();
        return containerCharge*totalDistance*0.1;
    }


}
