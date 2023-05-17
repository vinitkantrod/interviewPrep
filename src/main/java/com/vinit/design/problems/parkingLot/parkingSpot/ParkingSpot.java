package com.vinit.design.problems.parkingLot.parkingSpot;

import com.vinit.design.problems.parkingLot.Vehicle;

public class ParkingSpot {

    int id;
    Boolean isEmpty;
    Vehicle vehicle;
    int price;
    public ParkingSpot() {
        price = 5;
    };

    public void parkVehicle(Vehicle _vehicle) {
        vehicle = _vehicle;
        isEmpty = false;
    }
    public void removeVehicle() {
        vehicle = null;
        isEmpty = true;
    }
}
