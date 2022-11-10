package com.example.demo.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document("user")
@Data
public class User {
    @Id
    String id;

    String username;
    String password;
    ArrayList<Case> cases;
}
