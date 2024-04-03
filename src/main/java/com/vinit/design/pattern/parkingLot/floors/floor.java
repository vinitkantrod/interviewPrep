package com.vinit.design.pattern.parkingLot.floors;

public interface floor {
    public int checkCarParkingAvailable();
    public int checkBikeParkingAvailable();

    public Boolean reserveSpot(int id);
    public Boolean unreserveSpot(int id);
    public void display();
}
