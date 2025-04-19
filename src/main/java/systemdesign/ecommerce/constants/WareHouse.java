package systemdesign.ecommerce.constants;

public enum WareHouse {

    MUMBAI(100.23,200.44);

    private double log;
    private double alt;

    WareHouse(double log, double alt){
        this.log=log;
        this.alt=alt;
    }

    public double getLog() {
        return log;
    }

    public double getAlt() {
        return alt;
    }


}
