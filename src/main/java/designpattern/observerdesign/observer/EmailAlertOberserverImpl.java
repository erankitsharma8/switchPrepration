package designpattern.observerdesign.observer;

import designpattern.observerdesign.oberservable.StocksOberservable;

public class EmailAlertOberserverImpl implements NotificationAlertObserver{

    StocksOberservable stocksOberservable;
    String email;

    public EmailAlertOberserverImpl(StocksOberservable stocksOberservable,String email){
        this.stocksOberservable=stocksOberservable;
        this.email=email;
    }
    @Override
    public void update() {
        sendEmail(email,"Item is available");
    }

    private void sendEmail(String email,String message){
       System.out.println("Email is : "+email+" the message is: "+message);
    }
}
