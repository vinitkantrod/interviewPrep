package com.vinit.design.pattern.strategyPattern;

import com.vinit.design.pattern.strategyPattern.strategy.NormalDriveStrategy;

public class PassengerVehicle extends  Vehicle{

    PassengerVehicle() {
        super(new NormalDriveStrategy());
    }
}
