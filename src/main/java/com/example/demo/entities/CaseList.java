package com.example.demo.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;

@Document("caselist")
@Data
public class CaseList {
    @Id
    String id;

    @Field(name = "user_id")
    String userId;
    @Field(name = "case_list")
    ArrayList<Case> caseList;
}
