package com.vinit.design.pattern.parkingLot;

public class GetId {
    private int newId;
    private int prevCount;
    public GetId() {
        newId = 0;
        prevCount = 0;
    }
    private int getNewId() {
        newId = prevCount++;
        prevCount = newId;
        return newId;
    }
}
