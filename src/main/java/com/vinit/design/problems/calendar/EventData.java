package com.vinit.design.problems.calendar;

import java.util.*;

public class EventData {
    private static Map<Integer, Event> idEventData;
    private EventData() {
        idEventData = new HashMap<>();
    }
    private static EventData eventData;
    public static EventData getInstance() {
        if (eventData == null) {
            eventData = new EventData();
        }
        return eventData;
    }
    public Boolean insertEvent(Event e) {
        if (idEventData.containsKey(e.id)) return false;
        idEventData.put(e.id, e);
        return true;
    }
    public Event get(int id) {
        return idEventData.get(id);
    }
    public List<Event> getAll() {
        return new ArrayList<>(idEventData.values());
    }
    public void print() {
        System.out.println(idEventData);
    }
}
