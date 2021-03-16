package com.vinit.dsalgo.machine_coding.tic_tac_toe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParkingLot {

    public static Parking parking;

    public static class Parking {
        public String name;
        public int floors;
        public List<ParkingFloor> parkings;

        public Parking() {
            this.parkings = new ArrayList<ParkingFloor>();
            this.name = "PR1234";
        }
    }

    public static class ParkingFloor{

        public int slots;
        public int openSlots;
        public int closedSlots;
        public List<String> parkingSlots;

        public ParkingFloor(int slots) {
            this.slots = slots;
            this.openSlots = slots;
            this.parkingSlots = new ArrayList<String>();
            initializeParkingSlots();
        }

        private void initializeParkingSlots() {
            for (int i = 0; i < slots; i++) {
                parkingSlots.add("");
            }
        }
    }

    public static void main(String args[]) {
        System.out.println("******************************************");
        System.out.println("               PARKING LOT                ");
        System.out.println("******************************************");
        calculateParking();
        System.out.println("******************************************");
    }

    public static void calculateParking() {
        parking = new Parking();
        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(System.in)
            );
             while (true) {
                 System.out.println("\nWhat queries do you want to execute.");
                 System.out.println("\t1. Create Parking Lot");
                 System.out.println("\t2. Display free count");
                 System.out.println("\t3. Display free slots");
                 System.out.println("\t4. Display occupied slots");
                 System.out.println("\t5. Park Vehicle");
                 System.out.println("\t6. Un-park Vehicle");
                 System.out.println("\t7. EXIT");
                 String query = reader.readLine();
                 if (query.equalsIgnoreCase("exit") || query.equalsIgnoreCase("7")) break;
                 int qNo = Integer.parseInt(query);
                 if (qNo > 7 || qNo < 0) System.out.println("Enter valid number.\n");
                 if (qNo == 1) {
                     System.out.println("\nEnter parking_lot name, no of floors and no of slots for each floor as a space seperated values.");
                     String[] s = new String[3];
                     s[0] = "";
                     s[1] = "";
                     s[2] = "";
                     s = reader.readLine().split(" ");
                     while (s[2].equalsIgnoreCase("")) {
                         System.out.println("Please enter valid input.");
                         s = reader.readLine().split(" ");
                     }
                     String parkingLotName = s[0];
                     int floors = Integer.parseInt(s[1]);
                     int slots = Integer.parseInt(s[2]);
                     parking.name = parkingLotName;
                     parking.floors = floors;
                     for (int i = 0; i < floors; i++) {
                         parking.parkings.add(new ParkingFloor(slots));
                     }
                     displayCompleteParking();
                 }
                 if (qNo == 2 || qNo == 3 || qNo == 4) {
                     System.out.println("\nSelect the Vehicle the Type");
                     System.out.println("\t1. Bike (B)");
                     System.out.println("\t2. Car (C)");
                     System.out.println("\t3. Truck (T)");
                     String s = reader.readLine();
                     Integer type = Integer.parseInt(s);
                     if (qNo == 2) displayFreeCount(type);
                     if (qNo == 3) displayFreeSlots(type);
                 }
             }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void displayFreeCount(Integer type) {
        if (type == 3) {
            System.out.println("\nFree Count for Vehicle Type Truck ::");
            for (int i = 0; i < parking.parkings.size(); i++) {
                int freeCount = 0;
                for (int j = 0; j < Math.min(1, parking.parkings.get(i).slots); j++) {
                    if (parking.parkings.get(i).parkingSlots.get(j).equalsIgnoreCase("")) freeCount++;
                }
                System.out.println("Floor " + (i + 1) + " => " + freeCount);
            }
        }
        if (type == 2) {
            System.out.println("\nFree Count for Vehicle Type Car ::");
            for (int i = 0; i < parking.parkings.size(); i++) {
                int freeCount = 0;
                for (int j = 3; j < parking.parkings.get(i).slots; j++) {
                    if (parking.parkings.get(i).parkingSlots.get(j).equalsIgnoreCase("")) freeCount++;
                }
                System.out.println("Floor " + (i + 1) + " => " + freeCount);
            }
        }
        if (type == 1) {
            System.out.println("\nFree Count for Vehicle Type Bike ::");
            for (int i = 0; i < parking.parkings.size(); i++) {
                int freeCount = 0;
                for (int j = 1; j < Math.min(3, parking.parkings.get(i).slots); j++) {
                    if (parking.parkings.get(i).parkingSlots.get(j).equalsIgnoreCase("")) freeCount++;
                }
                System.out.println("Floor " + (i + 1) + " => " + freeCount);
            }
        }
    }

    public static void displayFreeSlots(Integer type) {
        if (type == 3) {
            System.out.println("\nFree Count for Vehicle Type Truck ::");
            for (int i = 0; i < parking.parkings.size(); i++) {
                String freeCount = "";
                for (int j = 0; j < Math.min(1, parking.parkings.get(i).slots); j++) {
                    if (parking.parkings.get(i).parkingSlots.get(j).equalsIgnoreCase("")) freeCount = freeCount.concat((j + 1) + ", ");
                }
                System.out.println("Floor " + (i + 1) + " => " + freeCount.substring(freeCount.length() - 1));
            }
        }
        if (type == 2) {
            System.out.println("\nFree Count for Vehicle Type Car ::");
            for (int i = 0; i < parking.parkings.size(); i++) {
                String freeCount = "";
                for (int j = 3; j < parking.parkings.get(i).slots; j++) {
                    if (parking.parkings.get(i).parkingSlots.get(j).equalsIgnoreCase("")) freeCount = freeCount.concat((j + 1) + ", ");
                }
                System.out.println("Floor " + (i + 1) + " => " + freeCount.substring(freeCount.length() - 1));
            }
        }
        if (type == 1) {
            System.out.println("\nFree Count for Vehicle Type Bike ::");
            for (int i = 0; i < parking.parkings.size(); i++) {
                String freeCount = "";
                for (int j = 1; j < Math.min(3, parking.parkings.get(i).slots); j++) {
                    if (parking.parkings.get(i).parkingSlots.get(j).equalsIgnoreCase("")) freeCount = freeCount.concat((j + 1) + ", ");
                }
                System.out.println("Floor " + (i + 1) + " => " + freeCount.substring(freeCount.length() - 1));
            }
        }
    }

    public static void displayCompleteParking() {
        System.out.println("\nParking name: " + parking.name);
        for (int i = 0; i < parking.parkings.size(); i++) {
            System.out.print("Floor " + (i + 1) + " parking :: Total Slots: " + parking.parkings.get(i).slots +
                    ", Available Slots: " + parking.parkings.get(i).openSlots +
                    ", Filled Slots: " + parking.parkings.get(i).closedSlots +
                    ", All Slots: ");
            for (int j = 0; j < parking.parkings.get(i).slots; j++) {
                System.out.print(" | -");
            }
            System.out.println();
        }
    }
}
