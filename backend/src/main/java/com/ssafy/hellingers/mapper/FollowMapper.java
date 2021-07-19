package com.ssafy.hellingers.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.hellingers.dao.FollowDao;

@Mapper
public interface FollowMapper {
    public void follow(FollowDao follow);
    public void unfollow(FollowDao follow);
    public int isFollow(FollowDao follow);
    public List<FollowDao> followingList(int following_id);
    public List<FollowDao> followerList(int follower_id);

    // 작명 한계에 도달....
    // 맞팔 했는지 체크하는 기능 필요한가..?

    // 회원 탈퇴 정보 삭제
    public boolean deleteAllFollow(int user_id) throws SQLException;
}