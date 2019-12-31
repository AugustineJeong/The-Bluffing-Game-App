package com.example.undercover.Data;

import java.io.Serializable;

public class Player implements Serializable {

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
