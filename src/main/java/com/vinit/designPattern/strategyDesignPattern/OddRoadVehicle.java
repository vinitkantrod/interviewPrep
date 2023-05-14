package com.vinit.designPattern.strategyDesignPattern;

import com.vinit.designPattern.strategyDesignPattern.strategy.SpecialDriveStrategy;

public class OddRoadVehicle extends Vehicle {

    OddRoadVehicle() {
        super(new SpecialDriveStrategy());
    }

}
