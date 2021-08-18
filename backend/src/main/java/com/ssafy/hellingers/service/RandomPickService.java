package com.ssafy.hellingers.service;

import com.ssafy.hellingers.mapper.RandomPickMapper;
import com.ssafy.hellingers.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RandomPickService {

    @Autowired
    private RandomPickMapper randomPickMapper;

    public List<User> random3People(Long selected_medal) throws Exception {
        return randomPickMapper.random3People(selected_medal);
    }

//    public List<Challenge> random3People(Long selected_medal) throws Exception {
//        return randomPickMapper.random3People(selected_medal);
//    }
}