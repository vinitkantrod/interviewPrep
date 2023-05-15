package com.vinit.design.pattern.observerPattern.observer;

import com.vinit.design.pattern.observerPattern.observable.StockObservable;

public class SmsNotifier implements NotificationAlertObserver {

    StockObservable observable;
    String mobile;
    public SmsNotifier(String _mobile, StockObservable _observable) {
        mobile = _mobile;
        observable = _observable;
    }
    @Override
    public void update() {
        sendSms(mobile, "This is a mobile notification for IPhone product. Hurry up!!");
    }

    private void sendSms(String mobile, String msg) {
        System.out.println("Hello user, " + mobile + ". " + msg);
    }
}
