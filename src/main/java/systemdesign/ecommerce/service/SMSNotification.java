package systemdesign.ecommerce.service;

import systemdesign.ecommerce.model.Order;
import systemdesign.ecommerce.model.User;

public class SMSNotification implements NotificationStrategy{


    @Override
    public void notification(User user, Order order) {
        // fetch user's mobile number and send sms with order details
    }
}
