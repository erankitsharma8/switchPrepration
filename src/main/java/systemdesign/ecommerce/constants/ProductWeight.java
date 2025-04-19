package systemdesign.ecommerce.constants;

public enum ProductWeight {

    GHEE0(500),
    GHEE1(1000),

    MILK0(500),

    MILK1(1000);

    private int weight;

    ProductWeight(int weight){
        this.weight=weight;
    }

    public int getWeight(){
        return this.weight;
    }
}
