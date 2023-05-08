package com.vinit.dsalgo.leetcode150MostAsked.array;

public class GasStation134 {

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        int total_tank = 0;
        int curr_tank = 0;
        int starting_station = 0;
        for (int i = 0; i < n; ++i) {
            System.out.print(i);
            total_tank += gas[i] - cost[i];
            curr_tank += gas[i] - cost[i];
            System.out.print(", total_tank: " + total_tank);
            System.out.println(", curr_tank: " + curr_tank);
            // If one couldn't get here,
            if (curr_tank < 0) {
                // Pick up the next station as the starting one.
                starting_station = i + 1;
                // Start with an empty tank.
                curr_tank = 0;
            }
        }
        return total_tank >= 0 ? starting_station : -1;
    }

    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5}; int[] cost = {3,4,5,1,2};
        System.out.println(canCompleteCircuit(gas, cost));
    }
}
