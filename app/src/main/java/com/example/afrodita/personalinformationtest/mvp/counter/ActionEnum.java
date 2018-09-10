package com.example.afrodita.personalinformationtest.mvp.counter;

public enum ActionEnum {

    INCREMENT("increment"),
    DECREMENT("decrement");

    String action;

    ActionEnum(String action) {
        this.action = action;
    }

    public String getAction() {
        return action ;
    }
}
