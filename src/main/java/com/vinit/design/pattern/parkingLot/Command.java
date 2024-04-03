package com.vinit.design.pattern.parkingLot;

public enum Command implements CommandI {
    create_parking_lot() {
        @Override
        public void execute(String[] details, ParkingSpace space) {
            // Create Parking Slit (Integer.parseInt(details[1]));


        }
    },
//    create_entry_point() {
//
//    },
//    create_exit_point() {
//
//    },
//    create_floor() {
//
//    },
//    build_parking_lot() {
//
//    }
}
