package com.example.undercover.Data;

public class Player {

    private String name;
    private boolean isSpy;

    public Player(String name) {
        this.name = name;
        this.isSpy = false;
    }

    public void setSpy() {
        this.isSpy = true;
    }

    public String getName() {
        return name;
    }

    public boolean isSpy() {
        return isSpy;
    }
}
