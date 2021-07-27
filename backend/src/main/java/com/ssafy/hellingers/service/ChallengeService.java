package com.ssafy.hellingers.service;

import com.ssafy.hellingers.model.Challenge;
import com.ssafy.hellingers.repository.ChallengeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChallengeService {

    @Autowired
    ChallengeRepository challengeRepository;

    public List<Challenge> selectAll() {
        List<Challenge> all = challengeRepository.findAll();
        System.out.println("JPA 호출!@");
        for(Challenge a : all) {
            System.out.println(a.getTitle());
        }
        return all;
    }

//    public List<Challenge> selectRandomly5() {
//        return null;
//    }
//
//    public Boolean fileUpload() {
//        return null;
//    }


}