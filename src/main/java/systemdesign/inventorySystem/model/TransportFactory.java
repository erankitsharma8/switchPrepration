package systemdesign.inventorySystem.model;

public class TransportFactory {
    public Transporter createTransportBean(String transport){
        if(null==transport || transport.isEmpty())
            return null;

        switch (transport){
            case "ship":
                return new Ship();
            case "truck":
              //  return new Truck();
            default:
                return null;
        }
    }
}
