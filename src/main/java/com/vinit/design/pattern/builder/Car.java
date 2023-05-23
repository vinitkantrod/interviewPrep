package com.vinit.design.pattern.builder;

public class Car {
    int seat;
    int headlight;
    String headlightType;
    Boolean rooftop;
    int tyreSize;
    String engineType;

    public Car() {}

    public String toString() {
        return "Car has " + seat + " seats.\nTheir are " + headlight + " headlights." +
                "\nThe headlight type is " + headlightType + ".\nThe tyre size is " + tyreSize + "." +
                "\nEngine type is " + engineType + ".\n----------------------------------------";
    }
}
