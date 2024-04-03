package com.vinit.calendarSystem;

import com.vinit.calendarSystem.events.Event;

import java.util.*;

public class PQ {

    // Heap -> Events(startTime, endTime, List<Users>)
    PriorityQueue<Event> queueList;
    public PQ () {
        this.queueList = new PriorityQueue<>((e1, e2) -> {
            long l = e1.starttime.getTime() - e2.starttime.getTime();
            return Math.toIntExact(l);
        });
    }

    public void addQueue(Event event) {
        queueList.add(event);
    }
}
