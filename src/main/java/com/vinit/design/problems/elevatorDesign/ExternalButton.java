package com.vinit.design.problems.elevatorDesign;

public class ExternalButton implements Button{
    int up;
    int down;

    ExternalButton() {
        up = 0;
        down = 1;
    }
    @Override
    public void press(int _id) {

    }
}
