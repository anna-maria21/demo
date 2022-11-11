package com.example.demo.repositories;

import com.example.demo.entities.CaseList;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CaseListRepository extends MongoRepository<CaseList, String> {
    public CaseList findCaseListByUserId(String id);
    public CaseList findCaseListById(String id);
}
