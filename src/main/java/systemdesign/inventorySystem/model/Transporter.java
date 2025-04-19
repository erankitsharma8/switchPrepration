package systemdesign.inventorySystem.model;

import systemdesign.inventorySystem.constants.Containers;

import java.util.List;

public abstract class Transporter {

    int number;
    long capacity;

    List<Containers> containersList;
    abstract long calculateBill();
}
