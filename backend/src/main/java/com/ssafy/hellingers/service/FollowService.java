package com.ssafy.hellingers.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.hellingers.dto.FollowDto;

public interface FollowService {
    public void follow(FollowDto follow);
    public void unfollow(FollowDto follow);
    public int isFollow(FollowDto follow);
    public List<FollowDto> followingList(int following_id);
    public List<FollowDto> followerList(int follower_id);
    public int checkFollows(FollowDto follow);
    public void willFollows(FollowDto follow);
    public void onewayFollows(FollowDto follow);
    public void roundFollows(FollowDto follow);
    public void deleteFollows(FollowDto followDto);

    public boolean deleteAllFollow(int user_id) throws SQLException;
}