package com.vinit.designPattern.strategyDesignPattern;

import com.vinit.designPattern.strategyDesignPattern.strategy.DriveStrategy;

public class Vehicle implements DriveStrategy {

    DriveStrategy driveStrategy;

    Vehicle(DriveStrategy _driveStrategy) {
        driveStrategy = _driveStrategy;
    }
    public void drive() {
        driveStrategy.drive();
    }
}
