package com.vinit.dsalgo.graphs.algoexpert;

import java.util.*;

public class BoggleWord {

    public static List<String> boggleBoard(char[][] board, String[] words) {
        Set<String> finalWordsSet = new HashSet<>();
        List<String> finalWords = new ArrayList<>();
        Boolean[][] visited = new Boolean[board.length][];
        for (int i = 0; i < board.length; i++) {
            visited[i] = new Boolean[board[i].length];
            for (int j = 0; j < board[i].length; j++) visited[i][j] = false;
        }
        Tries tries = new Tries();
        for (String word : words) tries.add(word);
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                explore(i, j, board, visited, tries.root, finalWordsSet);

        finalWords.addAll(finalWordsSet);
        return finalWords;
    }

    public static void explore(
            int i,
            int j,
            char[][] board,
            Boolean[][] visited,
           TrieNode trieNode,
            Set<String> finalWords
    ) {
        if (visited[i][j]) return;
        Character letter = board[i][j];
        if (!trieNode.children.containsKey(letter)) return;
        visited[i][j] = true;
        trieNode = trieNode.children.get(letter);
        if (trieNode.children.containsKey('*')) {
            System.out.println("adding word: " + trieNode.endWord);
            finalWords.add(trieNode.endWord);
        }
        List<Integer[]> neighbors = getNeighbours(i,j, board);
        System.out.println("i: " + i + ", j: " + j);
        for (Integer[] neighbor : neighbors)
            explore(neighbor[0], neighbor[1], board, visited, trieNode, finalWords);

        visited[i][j] = false;
    }

    public static List<Integer[]> getNeighbours(int i, int j, char[][] board) {
        List<Integer[]> neighbors = new ArrayList<>();
        if (i > 0 && j > 0) {
            neighbors.add(new Integer[]{i - 1, j - 1});
        }
        if (i > 0 && j < board[0].length - 1) {
            neighbors.add(new Integer[]{i - 1, j + 1});
        }
        if (i < board.length - 1 && j < board[0].length - 1){
            neighbors.add(new Integer[]{i + 1, j + 1});
        }
        if (i < board.length - 1 && j > 0) {
            neighbors.add(new Integer[]{i + 1, j - 1});
        }
        if (i > 0) {
            neighbors.add(new Integer[]{i - 1, j});
        }
        if (i < board.length - 1) {
            neighbors.add(new Integer[]{i + 1, j});
        }
        if (j > 0) {
            neighbors.add(new Integer[]{i, j - 1});
        }
        if (j < board[0].length - 1) {
            neighbors.add(new Integer[]{i, j + 1});
        }
        // Clockwise direction
        for (Integer[] n : neighbors)
            System.out.print(Arrays.toString(n));
        System.out.println("");
        return neighbors;
    }

    public static class TrieNode {
        public Map<Character, TrieNode> children = new HashMap<>();
        public String endWord = "";
    }

    public static class Tries {
        public TrieNode root;
        public Character endWord;

        public Tries() {
            this.root = new TrieNode();
            this.endWord = '*';
        }

        public void add(String str) {
            TrieNode node = this.root;
            for (int i = 0; i < str.length(); i++) {
                Character letter = str.charAt(i);
                if (!node.children.containsKey(letter))
                    node.children.put(letter, new TrieNode());
                node = node.children.get(letter);
            }
            node.children.put(this.endWord, null);
            node.endWord = str;
        }
    }

    public static void main(String args[]) {
        char[][] board = {
                {'t','h','i','s','i','s','a'},
                {'s','i','m','p','l','e','x'},
                {'b','x','x','x','x','e','b'},
                {'x','o','g','g','l','x','o'},
                {'x','x','x','D','T','r','a'},
                {'R','E','P','E','A','d','x'},
                {'x','x','x','x','x','x','x'},
                {'N','O','T','R','E','-','P'},
                {'x','x','D','E','T','A','E'}
        };
        String[] words = {"this","is","not", "a", "simple", "boggle", "board", "test", "REPEATED", "NOTRE-PEATED"};
        System.out.println(boggleBoard(board, words));
    }
}
