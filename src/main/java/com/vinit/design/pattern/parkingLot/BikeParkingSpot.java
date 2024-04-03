package com.vinit.design.pattern.parkingLot;

public class BikeParkingSpot implements ParkingSpot{

    public int id;
    public Boolean spotReserved;
    VehicleSpot vehicleSpot;

    public BikeParkingSpot(int _id, VehicleSpot _spot) {
        this.id = _id;
        this.vehicleSpot = _spot;
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
