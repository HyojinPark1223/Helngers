package com.ssafy.hellingers.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.hellingers.dto.FollowDto;

@Mapper
public interface FollowMapper {
    public void follow(FollowDto follow);
    public void unfollow(FollowDto follow);

    // 맞팔 판단(언팔할 때 사용)
    public int isFollow(FollowDto follow);
    public List<FollowDto> followingList(int following_id);
    public List<FollowDto> followerList(int follower_id);

    // 작명 한계에 도달....
    // 맞팔인지 판단2(맞팔 연결을 위해)
    public int checkFollows(FollowDto follow);
    // 맞팔을 위한 팔로우
    public void willFollows(FollowDto follow);
    // 상대는 맞팔을 안함
    public void onewayFollows(FollowDto follow);
    public void roundFollows(FollowDto follow);
    public void deleteFollows(FollowDto followDto);

    // 회원이 탈퇴시 모든 팔로우를 삭제해야함.
    public boolean deleteAllFollow(int user_id) throws SQLException;
}