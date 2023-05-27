package com.vinit.design.problems.elevatorDesign.objects;

import java.util.List;

public class Building {
    public List<Floor> floors;
    String name;

    public Building(String name, int totalFloor) {
        for (int i = 0; i < totalFloor; i++){
            floors.add(new Floor(i));
        }
    }

    public String toString() {
        return "Building " + name + " has " + floors.size() + " floors. ";
    }
}
