package com.vinit.design.problems.elevatorDesign.objects;

import com.vinit.design.problems.elevatorDesign.Button;
import com.vinit.design.problems.elevatorDesign.ExternalButtonDispatcher;
import com.vinit.design.problems.elevatorDesign.enums.Direction;

public class Floor {

    int id;
    String name;

    Display display;
    Direction direction;
    ExternalButtonDispatcher externalButtonDispatcher;

    Floor(int _id) {
        id = _id;
        name = "" + _id;
        externalButtonDispatcher = new ExternalButtonDispatcher();
    }

}
