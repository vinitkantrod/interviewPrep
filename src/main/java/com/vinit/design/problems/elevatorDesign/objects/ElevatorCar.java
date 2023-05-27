package com.vinit.design.problems.elevatorDesign.objects;

import com.vinit.design.problems.elevatorDesign.InternalButton;
import com.vinit.design.problems.elevatorDesign.enums.Direction;
import com.vinit.design.problems.elevatorDesign.enums.Status;
import com.vinit.design.problems.elevatorDesign.objects.Display;

public class ElevatorCar {
    int id;
    Display display;
    InternalButton buttonObj;
    Status status;
    Direction direction;

    ElevatorCar(int _id) {id = _id;}
}
