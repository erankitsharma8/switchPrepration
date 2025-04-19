package systemdesign.ecommerce.service;

import systemdesign.ecommerce.model.Order;
import systemdesign.ecommerce.model.User;

public class EmailNotification implements NotificationStrategy{
    @Override
    public void notification(User user, Order order) {
        // fetch email address from user and send order details from oder
    }
}
