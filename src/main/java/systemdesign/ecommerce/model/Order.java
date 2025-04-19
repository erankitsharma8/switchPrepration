package systemdesign.ecommerce.model;

import java.util.List;
import java.util.Map;

public class Order {

    int orderId;

    User user;

    List<Map<Item,Integer>> itemsList;

}
