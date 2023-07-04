package com.vinit.design.problems.calendar;

import java.time.LocalDateTime;

public class Event {
    private static int counter = 0;
    int id;
    LocalDateTime start;
    LocalDateTime end;
    EventType eventType;

    Event(LocalDateTime start, LocalDateTime end, EventType eventType) {
        id = counter++;
        this.start = start;
        this.end = end;
        this.eventType = eventType;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public EventType getEventType() {
        return eventType;
    }

    public String toString() {
        return ("Event_id: " + this.id +
                " starts from " + start.toLocalDate() + " " + start.getHour() + ":" + start.getMinute() +
                " till " + end.toLocalDate() + " " + end.getHour() + ":" + end.getMinute() + "");
    }
}
