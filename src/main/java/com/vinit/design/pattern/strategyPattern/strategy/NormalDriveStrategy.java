package com.vinit.design.pattern.strategyPattern.strategy;

public class NormalDriveStrategy implements DriveStrategy {

    @Override
    public void drive() {
        System.out.println("This is a normal Drive");
    }
}
