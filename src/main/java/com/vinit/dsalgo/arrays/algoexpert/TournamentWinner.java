package com.vinit.dsalgo.arrays.algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TournamentWinner {

    public static String tournamentWinner(
            ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {

        Map<String, Integer> map = new HashMap<>();
        int i = 0;
        String winner = "";
        while (i < competitions.size()) {
            String winningTeam = "";
            if (results.get(i) == 1) {
                winningTeam = competitions.get(i).get(0);
            } else {
                winningTeam = competitions.get(i).get(1);
            }
            if (map.containsKey(winningTeam)) {
                map.put(winningTeam, map.get(winningTeam) + 3);
            } else {
                map.put(winningTeam, 3);
            }
//            System.out.println(i + " _ " + winningTeam);
//            System.out.println(map);
            i++;
        }
        int winningScore = 0;
        String winningTeamName = "";
        for(Map.Entry e : map.entrySet()) {
            if ((int)e.getValue() > winningScore) {
                winningScore = (int) e.getValue();
                winningTeamName = String.valueOf(e.getKey());
            }
        }
        return winningTeamName;
    }
    public static void main(String args[]) {
        ArrayList<ArrayList<String>> competition = new ArrayList<>();
        competition.add(new ArrayList<>(Arrays.asList("html", "c#")));
        competition.add(new ArrayList<>(Arrays.asList("c#", "python")));
        competition.add(new ArrayList<>(Arrays.asList("python", "html")));
        ArrayList<Integer> results = new ArrayList<>(Arrays.asList(0,0,1));
        System.out.println(tournamentWinner(competition, results));
    }
}
