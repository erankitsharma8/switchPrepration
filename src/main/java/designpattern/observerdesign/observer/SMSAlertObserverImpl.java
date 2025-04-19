package designpattern.observerdesign.observer;

import designpattern.observerdesign.oberservable.StocksOberservable;

public class SMSAlertObserverImpl implements NotificationAlertObserver{

    StocksOberservable stocksOberservable;

    String mobileNum;

    public SMSAlertObserverImpl(StocksOberservable stocksOberservable,String mobileNum){
        this.stocksOberservable=stocksOberservable;
        this.mobileNum=mobileNum;
    }
    @Override
    public void update() {
        sendSMS(mobileNum,"Stock is available");
    }

    private void sendSMS(String mobileNum,String message){
        System.out.println("the mobile num is: "+mobileNum+" the message is: "+message);
    }
}
