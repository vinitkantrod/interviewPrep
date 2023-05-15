package com.vinit.design.pattern.strategyPattern.strategy;

public class SpecialDriveStrategy implements DriveStrategy {

    @Override
    public void drive() {
        System.out.println("This is a special Drive Strategy");
    }
}
