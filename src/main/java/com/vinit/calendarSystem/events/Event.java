package com.vinit.calendarSystem.events;

import com.vinit.calendarSystem.User;
import com.vinit.calendarSystem.enums.EventStatus;
import com.vinit.calendarSystem.enums.EventType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Event {
    public Long eventId;
    public String eventName;
    public Date starttime;
    public Date endTime;
    public EventType eventType;
    public EventStatus eventStatus;
    public User owner;

    public List<User> participants;

    public Event(String name, EventType _eventType, Date _startTime, Date _endTime, User _user) {
        this.eventName = name;
        this.eventType = _eventType;
        this.starttime = _startTime;
        this.endTime = _endTime;
        this.eventStatus = EventStatus.SCHEDULED;
        this.owner = _user;
        this.participants = new ArrayList<>();
    }

    public void addParticipants(List<User> participants) {
        this.participants = participants;
        System.out.println(this.participants.size());
    }
    public Boolean updateEvent(Date newStartTime, Date newEndTime) {
        if (newEndTime.getTime() < System.currentTimeMillis()) return false;
        this.starttime = newStartTime;
        this.endTime = newEndTime;
        return true;
    }

    public Boolean updateStatus(EventStatus status) {
        this.eventStatus = status;
        return true;
    }

    public Boolean updateEventType(EventType eType) {
        this.eventType = eType;
        return true;
    }

    public void notifyUsers() {
        for (User participant: participants) {
//            participant.eventUpdate(this.eventName);
        }
    }

    public String toString() {
        return "Event: " + starttime.toString() + ", endTime: " + endTime.toString() + ", participants: " + Arrays.asList(participants);
    }

}
