package com.vinit.calendarSystem;

import com.vinit.calendarSystem.events.Event;

import java.util.*;

public class CustomCalendar {
    User user;
    List<Event> eventList;
    public CustomCalendar(User _user) {

        this.user = _user;
        this.eventList = new ArrayList<>();
    }

    public List<Event> getAllEvents() {
        return this.eventList;
    }

    public void addEvent(Event e) {
        eventList.add(e);
    }

    public Boolean deleteEvent(Event e) {
        for (Event event : eventList) {
            if (Objects.equals(event, e)) eventList.remove(event);
        }
        return true;
    }

    public Boolean updateEvent(Event e, Date newstartTime, Date newEndTime) {
        for (Event event : eventList) {
            if (Objects.equals(event, e)) {
                event.updateEvent(newstartTime, newEndTime);
            }
        }
        return true;
    }
    public int getEventCount() {return this.eventList.size();}

    public String toString() {
        return "user: " + user.name + ", events: " + Arrays.asList(eventList);
    }
}
