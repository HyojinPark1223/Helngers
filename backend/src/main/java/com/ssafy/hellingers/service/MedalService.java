package com.ssafy.hellingers.service;

import com.ssafy.hellingers.model.Challenge;
import com.ssafy.hellingers.model.Medal;
import com.ssafy.hellingers.repository.MedalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedalService {

    @Autowired
    MedalRepository medalRepository;


    public List<Medal> selectAll() {
        List<Medal> all = medalRepository.findAll();
        System.out.println("JPA 호출!@");
        for(Medal a : all) {
            System.out.println(a.getTitle());
        }
        return all;
    }

}