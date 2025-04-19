package systemdesign.inventorySystem.constants;

public enum Locations {
    MUMBAI(100.100,200.100),
    CHENNAI(400.100,500.100),
    KOLKATA(700.100,800.100);

    private final double latitude;
    private final double longitude;

    Locations(double latitude,double longitude){
        this.latitude=latitude;
        this.longitude=longitude;
    }

    public double getLatitude(){
        return latitude;
    }

    public double getLongitude(){
        return longitude;
    }

}
