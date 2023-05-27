package com.vinit.design.problems.elevatorDesign;

import com.vinit.design.problems.elevatorDesign.objects.Floor;

import java.util.List;

public class InternalButton implements Button{
    List<Floor> floors;
    InternalButton(List<Floor> _floors) {floors = _floors;}

    @Override
    public void press(int _id) {

    }
}
