package systemdesign.inventorySystem.main;

import systemdesign.inventorySystem.service.InventorySystem;
import systemdesign.inventorySystem.model.Ship;
import systemdesign.inventorySystem.model.Transporter;
import systemdesign.inventorySystem.model.User;
import systemdesign.inventorySystem.constants.Containers;
import systemdesign.inventorySystem.constants.Locations;

import java.util.ArrayList;
import java.util.List;

public class MainInventory {
    public static void main(String[] args) {
        List<Containers> containersList=new ArrayList<>();
        containersList.add(Containers.LARGE);
        containersList.add(Containers.MEDIUM);
        containersList.add(Containers.LARGE);
        containersList.add(Containers.SMALL);
        User user=new User(containersList, Locations.MUMBAI,Locations.KOLKATA,"Ankit");
        Transporter transporter=new Ship();
        InventorySystem inventorySystem=new InventorySystem(transporter,user);
        System.out.println("Customer: "+"Ankit");
        System.out.println("Route: "+user.getFrom()+" :-> "+user.getTo());
        double cost=inventorySystem.containerCharges();
        System.out.println("Container charges: "+cost);
        double shipCost=inventorySystem.shippingCost(cost);
        System.out.println("Shipping charges 1% : "+shipCost);
        System.out.println("Total Cost: "+cost*shipCost);

    }
}
