package com.vinit.design.pattern.builder;

public class CarBuilder implements Builder {

    Car car;
    public CarBuilder() {
        car = new Car();
    }
    @Override
    public void setSeats(int _seats) {
        car.seat = _seats;
    }

    @Override
    public void setHeadlight(int _count, String _type) {
        car.headlight = _count;
        car.headlightType = _type;
    }

    @Override
    public void setRooftop(Boolean _isRooftop) {
        car.rooftop = _isRooftop;
    }

    @Override
    public void setTyreSize(int _size) {
        car.tyreSize = _size;
    }

    @Override
    public void setEngine(String _engine) {
        car.engineType = _engine;
    }

    public Car getProduct() {
        return car;
    }
}
