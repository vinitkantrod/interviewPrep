package com.vinit.design.pattern.strategyPattern;

import com.vinit.design.pattern.strategyPattern.strategy.SpecialDriveStrategy;

public class SportyVehicle extends Vehicle {

    public SportyVehicle() {
        super(new SpecialDriveStrategy());
    }
}
