package com.example.demo.entities;

import lombok.Data;

@Data
public class Case {
    private String item;
    private boolean isReady;

    public Case(String item, boolean isReady) {
        this.item = item;
        this.isReady = isReady;
    }

    public Case() {}
}
