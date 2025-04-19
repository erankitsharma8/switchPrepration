package designpattern.observerdesign.oberservable;

import designpattern.observerdesign.observer.NotificationAlertObserver;

import java.util.ArrayList;
import java.util.List;

public class IphoneOberservable implements StocksOberservable {

    public List<NotificationAlertObserver> notificationAlertObserverList=new ArrayList<>();

    public int count;
    @Override
    public void add(NotificationAlertObserver notificationAlertObserver) {
       notificationAlertObserverList.add(notificationAlertObserver);
    }

    @Override
    public void remove(NotificationAlertObserver notificationAlertObserver) {
       notificationAlertObserverList.remove(notificationAlertObserver);
    }

    @Override
    public void notifySubscriber() {
       notificationAlertObserverList.forEach(NotificationAlertObserver::update);
    }

    @Override
    public void setStockCount(int newStockCount) {
         if(count==0)
             notifySubscriber();
         count+=newStockCount;
    }

    @Override
    public int getStockCount() {
        return count;
    }
}
