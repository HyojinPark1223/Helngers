package com.ssafy.hellingers.service;

import com.ssafy.hellingers.dto.FollowDto;
import com.ssafy.hellingers.mapper.FollowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class FollowServiceImpl implements FollowMapper {

    @Autowired
    private FollowMapper followMapper;

    @Override
    public void follow(FollowDto follow){
        followMapper.follow(follow);
    }

    @Override
    public void unfollow(FollowDto follow){
        followMapper.unfollow(follow);
    };

    @Override
    public int isFollow(FollowDto follow){
        return followMapper.isFollow(follow);
    };


    // 팔로우 리스트 출력
    @Override
    public List<FollowDto> followingList(int from_id){
        return followMapper.followingList(from_id);
    };

    // 팔로워 리스트 출력
    @Override
    public List<FollowDto> followerList(int to_id){
        return followMapper.followerList(to_id);
    };

    @Override
    public int checkFollows(FollowDto follow){
        return followMapper.checkFollows(follow);
    }


    @Override
    public void onewayFollows(FollowDto follow){
        followMapper.onewayFollows(follow);
    };
    @Override
    public void willFollows(FollowDto follow){
        followMapper.willFollows(follow);
    };
    @Override
    public void updateFollows(FollowDto follow){
        followMapper.updateFollows(follow);
    };
    @Override
    public void deleteFollows(FollowDto followDto){
        followMapper.deleteFollows(followDto);
    };

    // 탈퇴한 회원 삭제. id = user_id
    @Override
    public boolean deleteAllFollow(int id) throws SQLException{
        return followMapper.deleteAllFollow(id);
    };
}
