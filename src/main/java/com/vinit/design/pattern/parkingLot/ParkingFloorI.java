package com.vinit.design.pattern.parkingLot;

public interface ParkingFloorI {
    public int checkCarParkingAvailable();
    public int checkBikeParkingAvailable();

    public Boolean reserveSpot(int id);
    public Boolean unreserveSpot(int id);
}
