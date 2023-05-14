package com.vinit.designPattern.strategyDesignPattern.strategy;

import com.vinit.designPattern.strategyDesignPattern.strategy.DriveStrategy;

public class SpecialDriveStrategy implements DriveStrategy {

    @Override
    public void drive() {
        System.out.println("This is a special Drive Strategy");
    }
}
