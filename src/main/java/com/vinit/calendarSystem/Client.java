package com.vinit.calendarSystem;

import com.vinit.calendarSystem.enums.EventType;
import com.vinit.calendarSystem.events.Event;

import java.util.*;

public class Client {

    public static void main(String[] args) {
        User u1 = new User("vinit");
        User u2 = new User("Srikant");
        User d1 = new User("dummy1");
        User d2 = new User("dummy2");
        User d3 = new User("dummy3");

        Event e1 = new Event("e1", EventType.MEETING, new Date(), new Date(), u1);
        Event e2 = new Event("e2",EventType.MEETING, new Date(), new Date(), u1);
        Event e3 = new Event("e3",EventType.MEETING, new Date(), new Date(), u1);
        Event e4 = new Event("e4",EventType.MEETING, new Date(), new Date(), u2);

        CustomCalendar u1Cal = new CustomCalendar(u1);
        CustomCalendar u2Cal = new CustomCalendar(u2);

        u1Cal.addEvent(e1);
        u1Cal.addEvent(e2);
        u1Cal.addEvent(e3);
        u2Cal.addEvent(e4);

        // Fetch Event
        System.out.println("Fetch all Events");
        u1Cal.getAllEvents().stream().forEach(System.out::println);
        System.out.println(u1Cal.getEventCount());

        // Delete Event
        u1Cal.deleteEvent(e2);
        System.out.println(u1Cal.getEventCount());

        System.out.println("Fetch all Events");
        u1Cal.getAllEvents().stream().forEach(System.out::println);

        System.out.println(u1Cal.getEventCount());

        // Update Event
        u1Cal.updateEvent(e3, new Date(), new Date());
        System.out.println(u1Cal.getEventCount());

        System.out.println("Adding participants...");
        // Add participants for e1
        List<User> eventOneParticipants = new ArrayList<>(Arrays.asList(d1, d2));
        e1.addParticipants(eventOneParticipants);

        // Add participants for e2
        List<User> eventTwoParticipants = new ArrayList<>(Arrays.asList(d3));
        e3.addParticipants(eventTwoParticipants);

        System.out.println(u1Cal.toString());
    }
}
