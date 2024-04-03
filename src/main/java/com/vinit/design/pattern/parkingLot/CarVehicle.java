package com.vinit.design.pattern.parkingLot;

public class CarVehicle implements Vehicle {
    public String vehicleNumber;
    public int numberOfWheels;
    public CarVehicle(String _number) {
        this.vehicleNumber = _number;
        this.numberOfWheels = 4;
    }

    @Override
    public String getNumber() {
        return this.vehicleNumber;
    }
}
