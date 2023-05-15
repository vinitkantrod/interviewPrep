package com.vinit.design.pattern.strategyPattern;

import com.vinit.design.pattern.strategyPattern.strategy.DriveStrategy;

public class Vehicle implements DriveStrategy {

    DriveStrategy driveStrategy;

    Vehicle(DriveStrategy _driveStrategy) {
        driveStrategy = _driveStrategy;
    }
    public void drive() {
        driveStrategy.drive();
    }
}
