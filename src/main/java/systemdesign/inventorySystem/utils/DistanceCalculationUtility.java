package systemdesign.inventorySystem.utils;

import systemdesign.inventorySystem.constants.Locations;

public class DistanceCalculationUtility {

    Locations loc1;
    Locations loc2;

    private static final double EARTH_RADIUS = 6371.0; // Radius in kilometers

    public DistanceCalculationUtility(Locations loc1,Locations loc2){
        this.loc1=loc1;
        this.loc2=loc2;
    }

    public double totalDistance(){
        double lat1 = Math.toRadians(this.loc1.getLatitude());
        double lon1 = Math.toRadians(this.loc1.getLongitude());
        double lat2 = Math.toRadians(this.loc2.getLatitude());
        double lon2 = Math.toRadians(this.loc2.getLongitude());

        double dlat = lat2 - lat1;
        double dlon = lon2 - lon1;

        double a = Math.pow(Math.sin(dlat / 2), 2)
                + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dlon / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return EARTH_RADIUS * c; // Distance in kilometers
    }
}
