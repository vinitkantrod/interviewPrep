package com.vinit.design.problems.parkingLot.parkingSpot;

import com.vinit.design.problems.parkingLot.Vehicle;

import java.util.List;

public class ParkingSpotManager {

    List<ParkingSpot> parkingSpotList;

    public ParkingSpotManager(List<ParkingSpot> _parkingSpotList) {
        parkingSpotList = _parkingSpotList;
    }

    public ParkingSpot find() {
        return parkingSpotList.get(0);
    }

    public void add(ParkingSpot _parkingSpot) {
        parkingSpotList.add(_parkingSpot);
    }
    public void remove(ParkingSpot _parkingSpot) {
        parkingSpotList.remove(_parkingSpot);
    }

    public void parkVehicle(Vehicle _vehicle) {};

    public void removeVehicle(Vehicle _vehicle) {};

}
