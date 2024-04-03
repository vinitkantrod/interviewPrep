package com.vinit.design.pattern.parkingLot;

import java.util.Scanner;

public class ParkingClient {

    public static void main(String[] args) {
        printCommands();
        readCommandAndExecute();
    }
    private static void readCommandAndExecute() {
        String inputLine;
        ParkingSpace parkingSpace = new ParkingSpace("HSR", 4);
        Scanner scanner = new Scanner(System.in);
        do {
            inputLine = scanner.nextLine();
            String[] inputs = inputLine.split(" ");
            Command cmd;
            try {
                cmd = Command.valueOf(inputs[0]);
                cmd.execute(inputs, parkingSpace);
            } catch (Exception e) {
                System.out.println("Please provide valid output...");
            }
            break;
        } while (true);
    }
    private static void printCommands() {
        System.out.println("***************************************************************************************");
        System.out.println("**********************  WELCOME TO PARKING SYSTEM APPLICATION  ************************");
        System.out.println("***************************************************************************************");
        System.out.println("*******************************  SAMPLE INPUT COMMANDS  *******************************");
        System.out.println("1. create_parking_lot {capacity}");
        System.out.println("2. park {VehicleNUmber} {VehicleType}");
        System.out.println("3. leave {SlotNumber}");
        System.out.println("4. status");
        System.out.println("5. park {VehicleNUmber} {VehicleType}");
    }
}
