package com.vinit.dsalgo.design.leetcode;

import java.util.HashMap;
import java.util.Map;

public class DesignUnderGroundSystem1396 {
    class UndergroundSystem {
        Map<Integer, String[]> checkInMap;
        Map<String, Integer[]> stationMap;

        public UndergroundSystem() {
            checkInMap = new HashMap<>();
            stationMap = new HashMap<>();
        }

        private String stationKey(String stationA, String stationB) {
            return stationA + "_" + stationB;
        }

        public void checkIn(int id, String stationName, int t) {
            checkInMap.put(id, new String[]{stationName, String.valueOf(t)});
        }

        public void checkOut(int id, String stationName, int t) {
            String startStation = checkInMap.get(id)[0];
            int startTime = Integer.parseInt(checkInMap.get(id)[1]);
            checkInMap.remove(id);
            String stationKey = stationKey(startStation, stationName);
            Integer[] values = stationMap.getOrDefault(stationKey, new Integer[]{0,0});
            values[0] += (t - startTime);
            values[1] += 1;
            stationMap.put(stationKey, values);
        }

        public double getAverageTime(String startStation, String endStation) {
            Integer[] values = stationMap.get(stationKey(startStation, endStation));
            return (double)(values[0]) / values[1];
        }
    }
}
