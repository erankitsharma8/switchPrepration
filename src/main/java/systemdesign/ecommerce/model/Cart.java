package systemdesign.ecommerce.model;

import java.util.List;
import java.util.Map;

public class Cart {

    List<Map<Item,Integer>> itemList;
    double totalCost;
    double shippingCost;


}
