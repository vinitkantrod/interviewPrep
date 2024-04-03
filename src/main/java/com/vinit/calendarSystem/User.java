package com.vinit.calendarSystem;

public class User {
    public Long userId;
    public String name;

    public User(String name) {
        this.name = name;
    }
    public String toString() {
        return this.name;
    }
}
