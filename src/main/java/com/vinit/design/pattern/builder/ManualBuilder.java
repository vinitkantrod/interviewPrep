package com.vinit.design.pattern.builder;

public class ManualBuilder implements Builder {

    Manual manual;

    public ManualBuilder() {
        manual = new Manual();
    }
    @Override
    public void setSeats(int _seats) {
        manual.seat = "This car contains " + _seats + " number of seats.";
    }

    @Override
    public void setHeadlight(int _count, String _type) {
        manual.headlight = "This car contains " + _count + " number of headlight. The type of the " +
                "headlight is " + _type;
    }

    @Override
    public void setRooftop(Boolean _isRooftop) {
        manual.rooftop = "This car contains " + _isRooftop + " which is a good feature for a family. " +
                "Children can enjoy the ride.";
    }

    @Override
    public void setTyreSize(int _size) {
        manual.tyreSize = "The car tyre size is " + _size + ".";
    }

    @Override
    public void setEngine(String _engine) {
        manual.engineType = "This car engine type is " + _engine + ".";
    }

    public Manual getProduct() {
        return manual;
    }
}
