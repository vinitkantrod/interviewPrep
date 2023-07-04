package com.vinit.design.problems.calendar;

import java.time.LocalDateTime;
import java.util.List;

public class Meeting extends Event{
    List<UserMeeting> userMeetingList;
    Meeting(LocalDateTime start, LocalDateTime end, EventType eventType) {
        super(start, end, eventType);
    }
    public void setUserMeetingList() {
    }

    public List<UserMeeting> getUserMeetingList() {
        return userMeetingList;
    }
}
