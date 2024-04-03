package com.vinit.design.pattern.parkingLot;

public class BikeVehicle implements Vehicle{
    public String vehicleNumber;
    public int numberOfWheels;
    public BikeVehicle(String _number) {
        this.vehicleNumber = _number;
        this.numberOfWheels = 2;
    }

    @Override
    public String getNumber() {
        return this.vehicleNumber;
    }
}
