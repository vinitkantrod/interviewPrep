package com.vinit.design.pattern.strategyPattern;

import com.vinit.design.pattern.strategyPattern.strategy.SpecialDriveStrategy;

public class OddRoadVehicle extends Vehicle {

    OddRoadVehicle() {
        super(new SpecialDriveStrategy());
    }

}
