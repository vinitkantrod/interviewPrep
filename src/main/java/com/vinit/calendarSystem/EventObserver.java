package com.vinit.calendarSystem;

public class EventObserver {

    User user;
    public EventObserver() {}

    public void eventUpdate(String eventName) {
        System.out.println("Received Notification for event: " + eventName);
    }
}
