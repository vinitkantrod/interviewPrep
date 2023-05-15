package com.vinit.design.pattern.observerPattern.observable;

import com.vinit.design.pattern.observerPattern.observer.NotificationAlertObserver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IphoneObservableImpl implements StockObservable {
    List<NotificationAlertObserver> observers = new ArrayList<>();
    int stockCount = 0;
    @Override
    public void add(NotificationAlertObserver _observer) {
        System.out.println("adding observer...");
        observers.add(_observer);
    }

    @Override
    public void remove(NotificationAlertObserver _observer) {
        observers.remove(_observer);
    }

    @Override
    public void notifySubscribers() {
        for (NotificationAlertObserver ob : observers) {
            ob.update();
        }
    }

    @Override
    public void setStockCount(int newStock) {
        if (stockCount == 0) {
            notifySubscribers();
        }
        stockCount += newStock;
    }

    @Override
    public int getStockCount() {
        return stockCount;
    }
}
