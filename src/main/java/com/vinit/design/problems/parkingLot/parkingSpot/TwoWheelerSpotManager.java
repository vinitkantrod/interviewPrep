package com.vinit.design.problems.parkingLot.parkingSpot;

import java.util.ArrayList;
import java.util.List;

public class TwoWheelerSpotManager extends ParkingSpotManager {

    List<ParkingSpot> parkingSpotList = new ArrayList<>();
    public TwoWheelerSpotManager(List<ParkingSpot> _parkingSpotList) {
        super(_parkingSpotList);
    }
}
