package com.ssafy.hellingers.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.hellingers.dto.FollowDto;
import com.ssafy.hellingers.mapper.FollowMapper;

@Service
public class FollowServiceImpl implements FollowService {
    @Autowired
    private FollowMapper followMapper;

    @Override
    public void follow(FollowDto follow) {
        followMapper.follow(follow);
    }

    @Override
    public void unfollow(FollowDto follow) {
        followMapper.unfollow(follow);
    }

    @Override
    public int isFollow(FollowDto follow) {
        return followMapper.isFollow(follow);
    }

    @Override
    public List<FollowDto> followingList(int following_id) {
        return followMapper.followingList(following_id);
    }

    @Override
    public List<FollowDto> followerList(int follower_id) {
        return followMapper.followerList(follower_id);
    }

    @Override
    public int checkFollows(FollowDto follow) {
        return followMapper.checkFollows(follow);
    }

    @Override
    public void willFollows(FollowDto follow) {
        followMapper.willFollows(follow);
    }

    @Override
    public void onewayFollows(FollowDto follow) {
        followMapper.onewayFollows(follow);
    }

    @Override
    public void roundFollows(FollowDto follow) {
        followMapper.roundFollows(follow);
    }

    @Override
    public void deleteFollows(FollowDto followDto) {
        followMapper.deleteFollows(followDto);
    }

    // 회원 탈퇴
    @Override
    public boolean deleteAllFollow(int user_id) throws SQLException {
        return followMapper.deleteAllFollow(user_id);
    }
}