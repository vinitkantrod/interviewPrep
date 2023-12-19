package com.vinit.dsalgo.arrays.leetcode;

public class CountHousesInCircularStreets2728 {

    public abstract class Street {
        public Street(int[] doors) {

        }

        public abstract void openDoor();
         public abstract void closeDoor();
         public abstract boolean isDoorOpen();
         public abstract void moveRight();
         public abstract void moveLeft();
    }
    public int houseCount(Street street, int k) {
        for (int i = 0; i < k; i++) {
            if (street.isDoorOpen()) street.closeDoor();
            street.moveRight();
        }
        street.openDoor();
        street.moveRight();
        int ans = 0;
        while (!street.isDoorOpen()) {
            ans++;
            street.moveRight();
        }
        return ans + 1;
    }
}
