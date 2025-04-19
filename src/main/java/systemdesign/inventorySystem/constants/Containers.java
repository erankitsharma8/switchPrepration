package systemdesign.inventorySystem.constants;

public enum Containers {
    SMALL(100,1000),
    MEDIUM(200,2000),
    LARGE(300,3000);

    private final int size;

    private final int price;

     Containers(int size,int price){
        this.size=size;
        this.price=price;
    }

    public int getSize(){
         return this.size;
    }

    public int getPrice() {
        return price;
    }
}
