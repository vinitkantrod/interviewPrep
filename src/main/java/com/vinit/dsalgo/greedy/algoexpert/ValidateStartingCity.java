package com.vinit.dsalgo.greedy.algoexpert;

public class ValidateStartingCity {
    public static int validStartingCity(int[] distances, int[] fuel, int mpg) {
        // Write your code here.
        int numberOfCities = distances.length;
        int milesRemaining = 0;

        int idxOfStartingCity = 0;
        int milesRemainingFromStartingCity = 0;

        for (int cityIdx = 1; cityIdx < numberOfCities; cityIdx++) {
            int distanceFromPrevCity = distances[cityIdx - 1];
            int fuelFromPreviousCity = fuel[cityIdx - 1];
            milesRemaining += fuelFromPreviousCity * mpg - distanceFromPrevCity;
            System.out.println(milesRemaining + " - " + milesRemainingFromStartingCity);
            if (milesRemaining < milesRemainingFromStartingCity) {
                idxOfStartingCity = cityIdx;
                milesRemainingFromStartingCity = milesRemaining;
            }
        }
        return idxOfStartingCity;
    }

    public static void main(String[] args) {
        int[] d = {5,25,15,10,15};
        int[] f = {1,2,1,0,3};
        int mpg = 10;
        System.out.println(validStartingCity(d, f, mpg));
    }
}
