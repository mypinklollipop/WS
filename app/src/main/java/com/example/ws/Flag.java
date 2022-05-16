package com.example.ws;

import java.io.Serializable;

public class Flag implements Serializable {
    private String name;
    private String charac;

    public Flag(String name, String charac){
        this.name = name;
        this.charac = charac;
    }

    public String getName() {
        return name;
    }

    public String getCharac() {
        return charac;
    }
}
