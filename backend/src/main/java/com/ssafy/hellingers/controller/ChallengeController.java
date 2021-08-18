package com.ssafy.hellingers.controller;

import com.ssafy.hellingers.model.Challenge;
import com.ssafy.hellingers.repository.ChallengeRepository;
import com.ssafy.hellingers.service.ChallengeService;
import com.ssafy.hellingers.service.RandomPickService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
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

    @Autowired
    RandomPickService randomPickService;

    @GetMapping("/list")
    public List<Challenge> printAll(){
        return challengeService.selectAll();
//        return challengeRepository.findAll();
    }


    @PostMapping("/list/{id}")
    public String updateChallengeList(@PathVariable Long id) throws Exception {
        try {
            randomPickService.insertRandom5Challenges(id);
            return "챌린지 리스트 갱신 성공!";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "챌린지 리스트 갱신 실패ㅜㅜ";
    }

    @GetMapping("/list/{id}")
    public List<Challenge> printAllChallenges(@PathVariable Long id) throws Exception {
        try {
            List<Challenge> challengeList = randomPickService.selectRandom5Challenges(id);
            return challengeList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}