package com.ssafy.hellingers.mapper;

import com.ssafy.hellingers.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RandomPickMapper {
    public List<User> random3People(Long selected_medal) throws Exception;
//    public List<Challenge> random5Challenges;
}
