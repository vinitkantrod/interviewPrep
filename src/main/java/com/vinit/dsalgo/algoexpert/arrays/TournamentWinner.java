package com.vinit.dsalgo.algoexpert.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TournamentWinner {

    public static String tournamentWinner(
            ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results
    ) {
        // Write your code here.
        Map<String, Integer> score = new HashMap<>();
        String winner = "";
        score.put(winner, 0);
        for (int i = 0; i < results.size(); i++) {
            String winningTeam = competitions.get(i).get((results.get(i) + 1) % 2);
            score.put(winningTeam, score.getOrDefault(winningTeam, 0) + 3);
            winner = score.get(winner) > score.get(winningTeam)
                    ? winner
                    : winningTeam;
        }
        return winner;
    }

    public static void main(String[] args) {

    }
}
