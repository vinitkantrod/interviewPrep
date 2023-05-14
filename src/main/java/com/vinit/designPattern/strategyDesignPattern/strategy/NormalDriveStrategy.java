package com.vinit.designPattern.strategyDesignPattern.strategy;

import com.vinit.designPattern.strategyDesignPattern.strategy.DriveStrategy;

public class NormalDriveStrategy implements DriveStrategy {

    @Override
    public void drive() {
        System.out.println("This is a normal Drive");
    }
}
