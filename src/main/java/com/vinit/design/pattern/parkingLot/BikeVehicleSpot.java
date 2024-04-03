package com.vinit.design.pattern.parkingLot;

public class BikeVehicleSpot implements VehicleSpot{
    Vehicle vehicle;
    public BikeVehicleSpot() {}
    @Override
    public int getPrice() {
        return 10;
    }
}
