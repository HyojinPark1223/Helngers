package com.ssafy.hellingers.controller;

import com.ssafy.hellingers.model.Challenge;
import com.ssafy.hellingers.repository.ChallengeRepository;
import com.ssafy.hellingers.service.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("challenges")
public class ChallengeController {

    private ChallengeRepository challengeRepository;

    @Autowired
    public ChallengeController(ChallengeRepository challengeRepository){
        this.challengeRepository = challengeRepository;
    }

    @Autowired
    ChallengeService challengeService;


    @GetMapping("/list")
    public List<Challenge> printAll(){
        return challengeService.selectAll();
//        return challengeRepository.findAll();
    }

}