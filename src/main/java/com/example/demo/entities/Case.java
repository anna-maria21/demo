package com.example.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
public class Case {
    private String item;

    @Field(name = "is_ready")
    private boolean isReady;

    public void changeStatus() {
        this.isReady = !this.isReady;
    }
}
