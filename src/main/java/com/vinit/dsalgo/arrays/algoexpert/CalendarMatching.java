package com.vinit.dsalgo.arrays.algoexpert;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class CalendarMatching {

    public static List<StringMeeting> calendarMatching(
            List<StringMeeting> calendar1,
            StringMeeting dailyBounds1,
            List<StringMeeting> calendar2,
            StringMeeting dailyBounds2,
            int meetingDuration) {
        List<Meeting> updatedCalendar1 = updateCalendar(calendar1, dailyBounds1);
        List<Meeting> updatedCalendar2 = updateCalendar(calendar2, dailyBounds2);
        System.out.println(Arrays.toString(updatedCalendar1.toArray()));
        System.out.println(Arrays.toString(updatedCalendar2.toArray()));
        List<Meeting> mergedCalendar = mergeCalendar(updatedCalendar1, updatedCalendar2);
        System.out.println(Arrays.toString(mergedCalendar.toArray()));
        List<Meeting> flattenedCalendar = flattenedCalendar(mergedCalendar);
        System.out.println(Arrays.toString(flattenedCalendar.toArray()));
        List<StringMeeting> availableMeetingSlot = getAvailableSlots(flattenedCalendar, meetingDuration);
        System.out.println(availableMeetingSlot);
        return availableMeetingSlot;
    }

    public static List<Meeting> updateCalendar(List<StringMeeting> calendar, StringMeeting dailyBound) {
        List<Meeting> updatedCalendar = new ArrayList<>();
        updatedCalendar.add(new Meeting(0, timeToMinute(dailyBound.start)));
        for (int i = 0; i < calendar.size(); i++) {
            updatedCalendar.add(new Meeting(timeToMinute(calendar.get(i).start), timeToMinute(calendar.get(i).end)));
        }
        updatedCalendar.add(new Meeting(timeToMinute(dailyBound.end), timeToMinute("23:59")));
        return updatedCalendar;
    }

    public static List<Meeting> mergeCalendar(List<Meeting> calendar1, List<Meeting> calendar2) {
        List<Meeting> merge = new ArrayList<>();
        int i = 0, j = 0;
        while (i < calendar1.size() && j < calendar2.size()) {
            Meeting meeting1 = calendar1.get(i);
            Meeting meeting2 = calendar2.get(j);
            if (meeting1.start <= meeting2.start) {
                merge.add(meeting1);
                i++;
            } else {
                merge.add(meeting2);
                j++;
            }
        }
        while (i < calendar1.size()) {
            merge.add(calendar1.get(i));
            i++;
        }
        while (j < calendar2.size()) {
            merge.add(calendar2.get(j));
            j++;
        }
        return merge;
    }

    public static List<Meeting> flattenedCalendar(List<Meeting> calendar) {
        List<Meeting> flattened = new ArrayList<>();
        flattened.add(calendar.get(0));
        for (int i = 1; i < calendar.size(); i++) {
            Meeting currentMeeting = calendar.get(i);
            Meeting previousMeeting = flattened.get(flattened.size() - 1);
            if (previousMeeting.end >= currentMeeting.start) {
                Meeting newPreviousMeeting = new Meeting(previousMeeting.start, Math.max(previousMeeting.end, currentMeeting.end));
                flattened.set( flattened.size() - 1, newPreviousMeeting);
            } else {
                flattened.add(currentMeeting);
            }
        }
        return flattened;
    }

    public static List<StringMeeting> getAvailableSlots(List<Meeting> flattenedCalendar, int meetingDuration) {
        List<StringMeeting> availableSlots = new ArrayList<>();
        for (int i = 1; i < flattenedCalendar.size(); i++) {
            int start = flattenedCalendar.get(i - 1).end;
            int end = flattenedCalendar.get(i).start;
            int diff = end - start;
            if (diff >= meetingDuration) {
                availableSlots.add(new StringMeeting(MinuteToTime(start), MinuteToTime(end)));
            }
        }
        return availableSlots;
    }

    public static int timeToMinute(String time) {
        int delimiterIdx = time.indexOf(":");
        int hour = Integer.parseInt(time.substring(0, delimiterIdx));
        int minute = Integer.parseInt(time.substring(delimiterIdx + 1, time.length()));
        return hour * 60 + minute;
    }

    public static String MinuteToTime(int time) {
        int hour = time / 60;
        int minutes = time % 60;
        String min = minutes < 10 ? "0" + minutes : String.valueOf(minutes);
        return hour + ":" + min;
    }

    public static void main(String args[]) {
        List<StringMeeting> calendar1 = new ArrayList<>();
        calendar1.add(new StringMeeting("9:00", "10:30"));
        calendar1.add(new StringMeeting("12:00", "13:00"));
        calendar1.add(new StringMeeting("16:00", "18:00"));
        List<StringMeeting> calendar2 = new ArrayList<>();
        calendar2.add(new StringMeeting("10:00", "11:30"));
        calendar2.add(new StringMeeting("12:30", "14:30"));
        calendar2.add(new StringMeeting("14:30", "15:00"));
        calendar2.add(new StringMeeting("16:00", "17:00"));
        StringMeeting dailyBound1 = new StringMeeting("9:00", "20:00");
        StringMeeting dailyBound2 = new StringMeeting("10:00", "18:30");
        int meetingDuration = 30;
        calendarMatching(calendar1, dailyBound1, calendar2, dailyBound2, meetingDuration);
    }

    static class StringMeeting {

        public String start;
        public String end;

        public StringMeeting(String start, String end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "[" + start + ":" + end + "]";
        }
    }

    static class Meeting {
        public int start;
        public int end;

        public Meeting(int s, int e) {
            this.start = s;
            this.end = e;
        }

        @Override
        public String toString() {
            return "[" + String.valueOf(start) + ":" + String.valueOf(end) + "]";
        }
    }
}
