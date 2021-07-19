package com.ssafy.hellingers.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.hellingers.dao.FollowDao;
import com.ssafy.hellingers.mapper.FollowMapper;

@Service
public class FollowServiceImpl implements FollowService {
    @Autowired
    private FollowMapper followMapper;

    @Override
    public void follow(FollowDao follow) {
        followMapper.follow(follow);
    }

    @Override
    public void unfollow(FollowDao follow) {
        followMapper.unfollow(follow);
    }

    @Override
    public int isFollow(FollowDao follow) {
        return followMapper.isFollow(follow);
    }

    @Override
    public List<FollowDao> followingList(int following_id) {
        return followMapper.followingList(following_id);
    }

    @Override
    public List<FollowDao> followerList(int follower_id) {
        return followMapper.followerList(follower_id);
    }

    @Override
    public boolean deleteAllFollow(int user_id) throws SQLException {
        return followMapper.deleteAllFollow(user_id);
    }
}