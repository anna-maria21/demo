package com.example.demo.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document("list")
@Data
public class List {
    @Id
    Long id;

    Long userId;
    ArrayList<Case> caseList;
}
