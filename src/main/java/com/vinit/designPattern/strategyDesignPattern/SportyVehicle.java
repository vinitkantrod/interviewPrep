package com.vinit.designPattern.strategyDesignPattern;

import com.vinit.designPattern.strategyDesignPattern.strategy.SpecialDriveStrategy;

public class SportyVehicle extends Vehicle {

    public SportyVehicle() {
        super(new SpecialDriveStrategy());
    }
}
