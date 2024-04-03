package com.vinit.design.pattern.parkingLot;

import java.util.List;

public class ParkingSpace {
    String name;
    ParkingFloor[] parkingFloorList;
    public ParkingSpace(String _name, int _floorCount) {
        this.name = _name;
        this.parkingFloorList = new ParkingFloor[_floorCount];
    }
}
