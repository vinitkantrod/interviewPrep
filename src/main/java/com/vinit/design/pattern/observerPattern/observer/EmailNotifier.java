package com.vinit.design.pattern.observerPattern.observer;

import com.vinit.design.pattern.observerPattern.observable.StockObservable;

public class EmailNotifier implements NotificationAlertObserver{

    StockObservable observable;
    String email;
    public EmailNotifier(String _email, StockObservable _observable) {
        email = _email;
        observable = _observable;
    }
    @Override
    public void update() {
        sendEmail(email, "This is a email notification for IPhone product. Hurry up");
    }

    private void sendEmail(String email, String msg) {
        System.out.println("Hello user, " + email + ". " + msg);
    }
}
