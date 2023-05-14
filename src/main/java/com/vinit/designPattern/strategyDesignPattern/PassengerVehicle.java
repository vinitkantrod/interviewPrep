package com.vinit.designPattern.strategyDesignPattern;

import com.vinit.designPattern.strategyDesignPattern.strategy.NormalDriveStrategy;

public class PassengerVehicle extends  Vehicle{

    PassengerVehicle() {
        super(new NormalDriveStrategy());
    }
    @Override
    public void drive() {
        super.drive();
    }
}
