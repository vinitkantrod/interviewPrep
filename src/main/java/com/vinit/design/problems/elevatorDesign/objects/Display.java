package com.vinit.design.problems.elevatorDesign.objects;

import com.vinit.design.problems.elevatorDesign.enums.Direction;

public class Display {

    Floor floor;
    Direction direction;

    Display() {}

    public String show() {
        return "Floor " + floor.name +
                "\nGoing " + direction.name();
    }
}
