package designpattern.observerdesign.oberservable;

import designpattern.observerdesign.observer.NotificationAlertObserver;

public interface StocksOberservable {

    void add(NotificationAlertObserver notificationAlertObserver);
    void remove(NotificationAlertObserver notificationAlertObserver);
    void notifySubscriber();
    void setStockCount(int stockCount);
    int getStockCount();
}
