package com.vinit.dsalgo.machine_coding.tic_tac_toe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SnakeAndLadder {

    public static void main(String args[]) {
        Map<Integer, Integer> snakeMap = new HashMap<>();
        Map<Integer, Integer> ladderMap = new HashMap<>();
        Map<String, Integer> personsMap = new HashMap<>();
        List<String> personArr = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(System.in)
            );
            String snakes = reader.readLine();
            int snakeCount = Integer.parseInt(snakes);
            while (snakeCount-- > 0) {
                String[] snakeReader = reader.readLine().split(" ");
                snakeMap.put(Integer.parseInt(snakeReader[0]), Integer.parseInt(snakeReader[1]));
            }
            String ladders = reader.readLine();
            int ladderCount = Integer.parseInt(ladders);
            while (ladderCount-- > 0) {
                String[] ladderReader = reader.readLine().split(" ");
                ladderMap.put(Integer.parseInt(ladderReader[0]), Integer.parseInt(ladderReader[1]));
            }
            int personCount = Integer.parseInt(reader.readLine());
            while (personCount-- > 0) {
                String name = reader.readLine();
                personArr.add(name);
                personsMap.put(name, 0);
            }
            System.out.println("Snake Map: " + snakeMap);
            System.out.println("Ladder Map: " + ladderMap);
            System.out.println("Person Map: " + personsMap);
            int personTurn = 0;
            while (personArr.size() != 1) {
                int diceValue = getRandonDiceValue();
                int startPos = personsMap.get(personArr.get(personTurn));
                if (startPos == 100) {
                    System.out.println(personArr.get(personTurn) + " wins the game.");
                    personArr.remove(personTurn);
                    personTurn = (personTurn + 1) % personArr.size();
                    continue;
                }
                int endPos = startPos + diceValue;
                if (endPos < 100) {
                    while (snakeMap.containsKey(endPos) || ladderMap.containsKey(endPos)) {
                        if (snakeMap.containsKey(endPos)) {
                            System.out.println("Bitten by snake...");
                            endPos = snakeMap.get(endPos);
                        }
                        if (ladderMap.containsKey(endPos)) {
                            System.out.println("Growing up the ladder...");
                            endPos = ladderMap.get(endPos);
                        }
                    }
                    personsMap.put(personArr.get(personTurn), endPos);
                }
                System.out.println(personArr.get(personTurn) + " rolled a " + diceValue + " and moved from " + startPos + " to " + endPos);
                if (endPos == 100) {
                    System.out.println(personArr.get(personTurn) + " wins the game.");
                    personArr.remove(personTurn);
                    personTurn = (personTurn + 1) % personArr.size();
                    continue;
                }
                personTurn = (personTurn + 1) % personArr.size();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int getRandonDiceValue() { return (int)(Math.random() * 6 + 1); }
}
