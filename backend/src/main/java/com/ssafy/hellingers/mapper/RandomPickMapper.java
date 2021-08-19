package com.ssafy.hellingers.mapper;

import com.ssafy.hellingers.model.Challenge;
import com.ssafy.hellingers.model.Medal;
import com.ssafy.hellingers.model.MedalResponse;
import com.ssafy.hellingers.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RandomPickMapper {
    public List<User> random3People(Long selected_medal) throws Exception;
    public List<Challenge> selectRandom5Challenges(Long user_id) throws Exception;
    public void insertRandom5Challenges(Long user_id) throws Exception;
    public void insertMedalstoUser(Long user_id) throws Exception;
    public List<MedalResponse> selectAllMedalsofUser(Long id) throws Exception;

}
