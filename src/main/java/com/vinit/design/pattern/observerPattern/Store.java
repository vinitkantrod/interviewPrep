package com.vinit.design.pattern.observerPattern;

import com.vinit.design.pattern.observerPattern.observable.IphoneObservableImpl;
import com.vinit.design.pattern.observerPattern.observable.StockObservable;
import com.vinit.design.pattern.observerPattern.observer.EmailNotifier;
import com.vinit.design.pattern.observerPattern.observer.NotificationAlertObserver;
import com.vinit.design.pattern.observerPattern.observer.SmsNotifier;

import java.util.concurrent.TimeUnit;

public class Store {

    public static void main(String[] args) {
        StockObservable iPhoneStockObservable = new IphoneObservableImpl();

        NotificationAlertObserver ob1 = new EmailNotifier("a@gmail.com", iPhoneStockObservable);
        NotificationAlertObserver ob2 = new EmailNotifier("b@gmail.com", iPhoneStockObservable);
        NotificationAlertObserver ob3 = new EmailNotifier("a@gmail.com", iPhoneStockObservable);
        NotificationAlertObserver ob4 = new EmailNotifier("d@gmail.com", iPhoneStockObservable);
        NotificationAlertObserver ob5 = new EmailNotifier("a@gmail.com", iPhoneStockObservable);

        NotificationAlertObserver ob6 = new SmsNotifier("123", iPhoneStockObservable);
        NotificationAlertObserver ob7 = new SmsNotifier("345", iPhoneStockObservable);
        NotificationAlertObserver ob8 = new SmsNotifier("678", iPhoneStockObservable);
        NotificationAlertObserver ob9 = new SmsNotifier("789", iPhoneStockObservable);

        iPhoneStockObservable.add(ob1);iPhoneStockObservable.add(ob2);
        iPhoneStockObservable.add(ob3);iPhoneStockObservable.add(ob4);
        iPhoneStockObservable.add(ob5);
        iPhoneStockObservable.add(ob6);iPhoneStockObservable.add(ob7);
        iPhoneStockObservable.add(ob8);iPhoneStockObservable.add(ob9);


        iPhoneStockObservable.setStockCount(100);
    }
}
