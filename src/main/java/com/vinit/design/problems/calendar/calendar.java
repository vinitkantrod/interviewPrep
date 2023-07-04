package com.vinit.design.problems.calendar;

import com.vinit.dsalgo.hashtable.leetcode.SumOfUniqueElement1748;

import java.io.File;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * Event {id, startTime, endTime, eventType}
 * Meeting extend Event {id, event, owner, agenda, description, userList, reminder = 30 mins prior, repeat = false}
 * User {id, name, email, contact, location}
 * Calendar {id, List<meetings>, }
 * enum EventType {birthday, Holiday, National Holiday, Sick leave, Out of Office}
 *
 */
public class calendar {

    public void getEvents() {

    }
    public static void main(String[] args) {
        System.out.println("================================");
        System.out.println("Welcome to the G-Calendar");
        System.out.println("================================");
        EventData eventData = EventData.getInstance();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("C A L E N D A R");
            System.out.println("Operation Supported :");
            System.out.println("\t1. View today's event");
            System.out.println("\t2. Create a meeting");
            System.out.println("\t3. Update a meeting");
            System.out.println("\t4. Delete a meeting");
            System.out.println("\t5. Add guest User");
            System.out.println("\t6. Remove guest User");
            System.out.println("\t7. View week event");
            System.out.println("\t8. View month event");
            System.out.println("Enter your option(numbers only/q to exit): ");
            String input = sc.next();
            if (input.equals("q") || input.equals("Q")) return;
            System.out.println();
            break;
        }
        Event e1 = new Event(LocalDateTime.now(), LocalDateTime.now().plusMinutes(30), EventType.MEETING);
        Event e2 = new Event(LocalDateTime.now(), LocalDateTime.now().plusMinutes(30), EventType.HOLIDAY);
        Event e3 = new Event(LocalDateTime.now(), LocalDateTime.now().plusMinutes(30), EventType.TASK);
        eventData.insertEvent(e1);
        eventData.insertEvent(e2);
        eventData.insertEvent(e3);
        eventData.print();
    }
}
