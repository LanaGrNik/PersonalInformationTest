package com.example.afrodita.personalinformationtest.mvp.counter;

public class CountResponse {
    public int value;
    public int error;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }
}
