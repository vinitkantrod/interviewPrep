package com.vinit.designPattern.strategyDesignPattern;

/**
 * Concept && Coding YT channel
 * Link: https://www.youtube.com/watch?v=Ep9_Zcgst3U&list=PL6W8uoQQ2c61X_9e6Net0WdYZidm7zooW&index=5
 */

import com.vinit.designPattern.strategyDesignPattern.SportyVehicle;
import com.vinit.designPattern.strategyDesignPattern.Vehicle;

public class VehicleMain {

    public static void main(String[] args) {
        SportyVehicle vehicle = new SportyVehicle();
        vehicle.drive();
    }

}
