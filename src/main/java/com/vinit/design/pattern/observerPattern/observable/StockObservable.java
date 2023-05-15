package com.vinit.design.pattern.observerPattern.observable;

import com.vinit.design.pattern.observerPattern.observer.NotificationAlertObserver;

public interface StockObservable {

    public void add(NotificationAlertObserver _observer);
    public void remove(NotificationAlertObserver _observer);
    public void notifySubscribers();
    public void setStockCount(int _stock);
    public int getStockCount();
}
