package com.vinit.design.pattern.parkingLot;

public class CarVehicleSpot implements VehicleSpot{
    Vehicle vehicle;
    public CarVehicleSpot() {}
    @Override
    public int getPrice() {
        return 20;
    }
}
