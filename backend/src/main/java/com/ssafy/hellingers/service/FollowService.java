package com.ssafy.hellingers.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.hellingers.dao.FollowDao;

public interface FollowService {
    public void follow(FollowDao follow);
    public void unfollow(FollowDao follow);
    public int isFollow(FollowDao follow);
    public List<FollowDao> followingList(int following_id);
    public List<FollowDao> followerList(int follower_id);

    public boolean deleteAllFollow(int user_id) throws SQLException;
}