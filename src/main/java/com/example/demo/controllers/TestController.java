package com.example.demo.controllers;

import com.example.demo.entities.Case;
import com.example.demo.entities.CaseList;
import com.example.demo.repositories.UserRepository;
import com.example.demo.repositories.CaseListRepository;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@RestController
@RequestMapping("/todolist")
public class TestController {

    final UserRepository userRepository;
    final CaseListRepository caseListRepository;

    private String id = "636a62a02f1175e04cec65d1";

    public TestController(CaseListRepository caseListRepository, UserRepository userRepository) {
        this.caseListRepository = caseListRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("{id}")
    String greeting(HttpSession httpSession, @PathVariable String id) {
        httpSession.setAttribute("userId", id);
//        System.out.println(caseListRepository.findCaseListById("636e2420a131361ef1841de4"));
        return "Hell World!!!!!!!!";
    }

    // виведення всіх елементів
    @GetMapping("/all-cases")
    CaseList getAllCasesByUserId() {
//        String id = httpSession.getAttribute("userId").toString();
        return caseListRepository.findCaseListByUserId(id);
    }


    // додавання елементу в список
    @PutMapping("/add-cases/{caseValue}")
    ArrayList<Case> addCaseToList(HttpSession httpSession, @PathVariable String caseValue) {
//        User curUser = userRepository.findUserById(httpSession.getAttribute("userId").toString());
        CaseList curUserCaseList = caseListRepository.findCaseListByUserId(id);
        curUserCaseList.getCaseList().add(new Case(caseValue, false));
        return curUserCaseList.getCaseList();
    }

    // видалення всіх елементів
    @DeleteMapping("/remove-cases")
    ArrayList<Case> removeAllCases() {
        CaseList curUserCaseList = caseListRepository.findCaseListByUserId(id);
        curUserCaseList.getCaseList().clear();
        return curUserCaseList.getCaseList();
    }

    // зміна статусу
    @PostMapping("/all-cases/{item}")
    ArrayList<Case> changeCaseStatus(@PathVariable String item) {
        CaseList curUserCaseList = caseListRepository.findCaseListByUserId(id);
        ArrayList<Case> curUserCases = curUserCaseList.getCaseList();
        curUserCases.stream().filter(i -> i.getItem().equals(item)).forEach(Case::changeStatus);
        return curUserCases;
    }

}
