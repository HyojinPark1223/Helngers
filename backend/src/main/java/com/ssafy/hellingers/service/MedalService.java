package com.ssafy.hellingers.service;

import com.ssafy.hellingers.model.Medal;
import com.ssafy.hellingers.repository.MedalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedalService {

    @Autowired
    MedalRepository medalRepository;


    public List<Medal> selectAll() {
        List<Medal> all = medalRepository.findAll();
        System.out.println("selectAll JPA 호출!@");
        for(Medal a : all) {
            System.out.println(a.getTitle());
        }
        return all;
    }

    public Optional<Medal> selectOne(Long id) {
        Optional<Medal> medal = medalRepository.findById(id);
        System.out.println("selectOne JPA 호출!@");
        return medal;
    }

}