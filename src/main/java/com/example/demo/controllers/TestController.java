package com.example.demo.controllers;

import com.example.demo.entities.Case;
import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/todolist")
public class TestController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/{id}")
    String greeting(@PathVariable String id, HttpSession httpSession) {
        httpSession.setAttribute("userId", id);
        return "Hell World!!!!!!!!";
    }

    // виведення всіх елементів
    @GetMapping("/{id}/all-cases")
    User getAllCasesByUserId(HttpSession httpSession, @PathVariable String id) {
//        String id = httpSession.getAttribute("userId").toString();
        return userRepository.findUserById(id);
    }


    // додавання елементу в список
    @PutMapping("/{id}/add-cases/{caseValue}")
    ArrayList<Case> addCaseToList(HttpSession httpSession, @PathVariable String caseValue, @PathVariable String id) {
//        User curUser = userRepository.findUserById(httpSession.getAttribute("userId").toString());
        User curUser = userRepository.findUserById(id);
        List<Case> curUserCases = curUser.getCases();
        curUserCases.add(new Case(caseValue, false));
        return curUser.getCases();
    }

    // видалення всіх елементів
    @DeleteMapping("/{id}/remove-cases")
    ArrayList<Case> removeAllCases(@PathVariable String id) {
        User curUser = userRepository.findUserById(id);
        curUser.getCases().clear();
        return curUser.getCases();
    }

    @PostMapping("/{id}/all-cases/{item}")
    ArrayList<Case> changeCaseStatus(@PathVariable String id, @PathVariable String item) {
        User curUser = userRepository.findUserById(id);
        ArrayList<Case> curUserCases = curUser.getCases();
        curUserCases.forEach(i -> {
            if (i.getItem().equals(item)) {
                i.changeStatus();
            }
        });
        return curUserCases;
    }

}
