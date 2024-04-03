package com.vinit.design.pattern.parkingLot;

public interface ParkingSpot {
    public Boolean isSpotAvailable();
    public void reserveSpot();
    public void unreserveSpot();

}
