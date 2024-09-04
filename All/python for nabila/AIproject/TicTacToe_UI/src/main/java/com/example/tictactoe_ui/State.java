package com.example.tictactoe_ui;

import java.util.Arrays;

public class State {
    private int position;//0,1,2,3,4,5,6,7,8
    private String[] state;

    public State(int position, String[] state) {
        this.position = position;
        this.state = state;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String[] getState() {
        return state;
    }

    public String getStateIndex(int i){
        return state[i];
    }

    public void setState(String[] state) {
        this.state = state;
    }

    public void changeState(int i, String player){
        state[i] = player;
    }

    @Override
    public String toString() {
        return "State{" +
                "position=" + position +
                ", state=" + Arrays.toString(state) +
                '}';
    }
}