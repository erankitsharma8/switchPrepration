package systemdesign.ecommerce.util;

import systemdesign.ecommerce.constants.WareHouse;

public class DistanceUtility {

    private static DistanceUtility instance;

    public DistanceUtility getInstance(){
        if(null==instance){
            return new DistanceUtility();
        }
        return instance;
    }

    private double totalDistance(String address){
        double userLocation=fetchLocationCorrdinates(address);
        return userLocation- WareHouse.MUMBAI.hashCode();
    }

    private double fetchLocationCorrdinates(String add){
        // logic to find the address cordinates
        return add.hashCode();
    }
}
