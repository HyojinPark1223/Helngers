package com.ssafy.hellingers.controller;

import com.ssafy.hellingers.model.Challenge;
import com.ssafy.hellingers.model.Medal;
import com.ssafy.hellingers.repository.ChallengeRepository;
import com.ssafy.hellingers.repository.MedalRepository;
import com.ssafy.hellingers.service.MedalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("medals")
public class MedalController {

    private MedalRepository medalRepository;

    @Autowired
    public MedalController(MedalRepository medalRepository){
        this.medalRepository = medalRepository;
    }

    @Autowired
    MedalService medalService;

    @GetMapping("/list")
    public List<Medal> printAll(){
//        return medalRepository.findAll();
        return medalService.selectAll();
    }

//    @GetMapping("/{id}")
//    public List<Medal> print5() {
//
//    }



}