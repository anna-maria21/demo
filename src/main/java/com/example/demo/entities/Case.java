package com.example.demo.entities;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
public class Case {
    private String item;

    @Field(name = "is_ready")
    private boolean isReady;

    public Case(String item, boolean isReady) {
        this.item = item;
        this.isReady = isReady;
    }

    public Case() {}

    public void changeStatus() {
        this.isReady = !this.isReady;
    }
}
