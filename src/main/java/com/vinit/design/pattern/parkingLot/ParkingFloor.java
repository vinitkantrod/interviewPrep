package com.vinit.design.pattern.parkingLot;

import java.util.List;

public class ParkingFloor {
    int floorId;
    ParkingSpot[] carParkingSpot;
    ParkingSpot[] bikeParkingSpot;
    int totalSpot;
    public ParkingFloor(int floorId, int carParkingNum, int bikeParkingNum) {
        this.floorId = floorId;
        this.totalSpot = carParkingNum + bikeParkingNum;
        carParkingSpot = new ParkingSpot[carParkingNum];
        bikeParkingSpot = new ParkingSpot[carParkingNum];
        int counter = 0;
        for (int i = 0; i < carParkingNum; i++) {
            carParkingSpot[i] = new CarParkingSpot(counter++, new CarVehicleSpot());
        }
        for (int i = 0; i < bikeParkingNum; i++) {
            bikeParkingSpot[i] = new BikeParkingSpot(counter++, new BikeVehicleSpot());
        }
    }
}
