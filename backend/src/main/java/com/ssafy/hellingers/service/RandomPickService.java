package com.ssafy.hellingers.service;

import com.ssafy.hellingers.mapper.RandomPickMapper;
import com.ssafy.hellingers.model.Medal;
import com.ssafy.hellingers.model.MedalResponse;
import com.ssafy.hellingers.model.User;
import com.ssafy.hellingers.model.Challenge;
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

    public List<Challenge> selectRandom5Challenges(Long user_id) throws Exception {
        return randomPickMapper.selectRandom5Challenges(user_id);
    }

    public void insertRandom5Challenges(Long user_id) throws Exception {
        randomPickMapper.insertRandom5Challenges(user_id);
    }

    public void insertMedalstoUser(Long user_id) throws Exception {
        randomPickMapper.insertMedalstoUser(user_id);
    }

    public List<MedalResponse> selectAllMedalsofUser(Long user_id) throws Exception {
        return randomPickMapper.selectAllMedalsofUser(user_id);
    }
}