package com.vinit.design.pattern.parkingLot;

public class CarParkingSpot implements ParkingSpot{
    public int id;
    public Boolean spotReserved;
    VehicleSpot vehicleSpot;

    public CarParkingSpot(int _id, VehicleSpot _spot) {
        this.id = _id;
        this.vehicleSpot = _spot;
        this.spotReserved = false;
    }
    @Override
    public Boolean isSpotAvailable() {
        return !spotReserved;
    }

    @Override
    public void reserveSpot() {
        spotReserved = true;
    }

    @Override
    public void unreserveSpot() {
        spotReserved = false;
    }
}
