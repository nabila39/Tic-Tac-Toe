package com.example.tictactoe_ui;

import java.util.ArrayList;
import java.util.Random;

public class Minimax {
    static String str ="";
    public int bestMove(State state, char player) {
        // First Player must be X
        Random random = new Random();
        int bestVal = (player == 'X') ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        int bestMove = 0;

        for (State move : successorsOf(state)) {
            int moveVal;
            if (player == 'X') {//Ai first
                moveVal = minValue(move);  // Minimize if AI played 1st
                if (moveVal > bestVal) {
                    bestVal = moveVal;
                    bestMove = move.getPosition();
                }
            } else {//user
                moveVal = maxValue(move);  // Maximize if Ai played 2nd
                if (moveVal < bestVal) {
                    bestVal = moveVal;
                    bestMove = move.getPosition();
                }
            }
        }

        return bestMove ;
    }


    // Maximizes the score
    private int maxValue(State state) {
        if (isTerminal(state)) {
            return utilityOf(state);
        }

        int bestScore = Integer.MIN_VALUE;
        for (State move : successorsOf(state)) {
            bestScore = Math.max(bestScore, minValue(move));
        }
        return bestScore;
    }

    // Minimizes the score
    private int minValue(State state) {
        if (isTerminal(state)) {
            return utilityOf(state);
        }

        int bestScore = Integer.MAX_VALUE;
        for (State move : successorsOf(state)) {
            bestScore = Math.min(bestScore, maxValue(move));
        }
        return bestScore;
    }


    public boolean isTerminal(State state) {//this method return true if either AI or Player win || all spots are reserved (draw)
        int takenSpots = 0;
        for (int a = 0; a < 9; a++) {
            if (state.getStateIndex(a).equals("X") || state.getStateIndex(a).equals("O")) {
                takenSpots++;
            }

            String line = checkState(state, a); //012

            //Check for Winners
            if (line.equals("XXX")) {
                return true;
            } else if (line.equals("OOO")) {
                return true;
            }

            if (takenSpots == 9) {
                return true;
            }
        }
        return false;
    }


    public int utilityOf(State state) {
        for (int a = 0; a < 8; a++) {
            String line = checkState(state, a);
            if (line.equals("XXX")) {
                return 1;
            } else if (line.equals("OOO")) {
                return -1;
            }

        }
        return 0;
    }

    private String checkState(State state, int a) {
        return switch (a) {
            case 0 -> state.getStateIndex(0) + state.getStateIndex(1) + state.getStateIndex(2);
            case 1 -> state.getStateIndex(3) + state.getStateIndex(4) + state.getStateIndex(5);
            case 2 -> state.getStateIndex(6) + state.getStateIndex(7) + state.getStateIndex(8);
            case 3 -> state.getStateIndex(0) + state.getStateIndex(3) + state.getStateIndex(6);
            case 4 -> state.getStateIndex(1) + state.getStateIndex(4) + state.getStateIndex(7);
            case 5 -> state.getStateIndex(2) + state.getStateIndex(5) + state.getStateIndex(8);
            case 6 -> state.getStateIndex(0) + state.getStateIndex(4) + state.getStateIndex(8);
            case 7 -> state.getStateIndex(2) + state.getStateIndex(4) + state.getStateIndex(6);
            default -> "";
        };
    }



    private ArrayList<State> successorsOf(State state) {//this method return all state that cane player play it
        ArrayList<State> possibleMoves = new ArrayList<>();
        int xMoves = 0;
        int oMoves = 0;
        String player;

        // Calculate player turn
        for (String s : state.getState()) {
            if (s.equals("X")) {
                xMoves++;
            } else if (s.equals("O")) {
                oMoves++;
            }
        }

        if (xMoves <= oMoves) {
            player = "X";
        } else {
            player = "O";
        }

        // Create all possible states if there are available moves
        for (int i = 0; i < 9; i++) {
            if (!state.getStateIndex(i).equals("X") && !state.getStateIndex(i).equals("O")) {
                String[] newState = state.getState().clone();
                newState[i] = player;
                possibleMoves.add(new State(i, newState));
            }
        }
        return possibleMoves;
    }
}
