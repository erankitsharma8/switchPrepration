package designpattern.observerdesign;

import designpattern.observerdesign.oberservable.IphoneOberservable;
import designpattern.observerdesign.oberservable.StocksOberservable;
import designpattern.observerdesign.observer.EmailAlertOberserverImpl;
import designpattern.observerdesign.observer.NotificationAlertObserver;
import designpattern.observerdesign.observer.SMSAlertObserverImpl;

public class Store {
    public static void main(String[] args) {
        StocksOberservable iphone=new IphoneOberservable();

        NotificationAlertObserver notificationAlertObserver=new EmailAlertOberserverImpl(iphone,"abc.gmail.com");
        NotificationAlertObserver notificationAlertObserver1=new SMSAlertObserverImpl(iphone,"number here");

        iphone.add(notificationAlertObserver);
        iphone.add(notificationAlertObserver1);
        iphone.setStockCount(10);
    }
}
