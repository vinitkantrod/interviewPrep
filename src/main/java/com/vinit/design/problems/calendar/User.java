package com.vinit.design.problems.calendar;

public class User {
    public static int counter = 0;
    int id;
    String name;
    String email;
    String contact;
    User(String email) {
        this.id = counter++;
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }

}
