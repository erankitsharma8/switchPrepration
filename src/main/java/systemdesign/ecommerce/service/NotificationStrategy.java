package systemdesign.ecommerce.service;

import systemdesign.ecommerce.model.Order;
import systemdesign.ecommerce.model.User;

interface NotificationStrategy {

    void notification(User user, Order order);
}
