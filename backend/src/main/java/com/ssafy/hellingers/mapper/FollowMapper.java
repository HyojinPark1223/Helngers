package com.ssafy.hellingers.mapper;

import com.ssafy.hellingers.dto.FollowDto;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface FollowMapper {
    public void follow(FollowDto follow);
    // 언팔
    public void unfollow(FollowDto follow);

    public int isFollow(FollowDto follow);

    // 팔로잉 리스트, 팔로우 리스트
    public List<FollowDto> followingList(int from_id);
    public List<FollowDto> followerList(int to_id);

    // 맞팔 체크(내가 팔로우를 걸었을 때 이게 맞팔인지 체크)
    public int checkFollows(FollowDto follow);

    // 맞팔은 아니고 내가 처음 팔로우를 함.
    public void onewayFollows(FollowDto follow);

    // 팔로우를 하려는데 상대가 이미 맞팔 되어있음.
    public void willFollows(FollowDto follow);

    // willFollows이후, 상대의 맞팔 상태 1로 변경
    public void updateFollows(FollowDto follow);

    // 내가 팔로우를 취소. 상대의 맞팔 상태는 다시 0으로.
    public void deleteFollows(FollowDto followDto);

    // 탈퇴한 회원 삭제. id = user_id
    public boolean deleteAllFollow(int id) throws SQLException;

}
