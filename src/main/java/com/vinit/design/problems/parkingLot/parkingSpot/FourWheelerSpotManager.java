package com.vinit.design.problems.parkingLot.parkingSpot;

import java.util.ArrayList;
import java.util.List;

public class FourWheelerSpotManager  extends  ParkingSpotManager {

    List<ParkingSpot> parkingSpotList = new ArrayList<>();
    public FourWheelerSpotManager(List<ParkingSpot> _parkingSpotList) {
        super(_parkingSpotList);
    }
}
