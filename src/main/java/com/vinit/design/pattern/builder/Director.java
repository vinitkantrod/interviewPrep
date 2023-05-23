package com.vinit.design.pattern.builder;

public class Director {

    public Director() {}

    public void manufactureCar(Builder builder) {
        builder.setSeats(2);
        builder.setTyreSize(20);
        builder.setEngine("Sporty");
        builder.setHeadlight(4, "led");
        builder.setRooftop(true);
    }

    public void generateManual(Builder builder) {
        builder.setSeats(2);
        builder.setTyreSize(20);
        builder.setEngine("Sporty");
        builder.setHeadlight(4, "led");
        builder.setRooftop(true);
    }

    public void generateCarAndManual(Builder builder) {
        manufactureCar(builder);
        generateManual(builder);
    }
}
