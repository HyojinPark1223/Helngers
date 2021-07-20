package com.ssafy.hellingers.dto;

public class FollowDto {
    private int follow_id;
    private int following_id;   // 팔로우를 거는 계정 아이디(주체)
    private int follower_id;    // 팔로우를 받는 계정 아이디(대상)
    private String following_nickname;
    private String follower_nickname;
    private boolean follows;   // 맞팔이 이뤄졌는지. 맞으면 T, 아니면 F


    public int getFollow_id() {
        return follow_id;
    }
    public void setFollow_id(int follow_id) {
        this.follow_id = follow_id;
    }

    // 팔로잉 아이디 받아오기
    public int getFollowing_id(){
        return following_id;
    }
    public void setFollowing_id(int following_id) {
        this.following_id = following_id;
    }

    // 팔로워 아이디 받아오기
    public int getFollower_id() {
        return follower_id;
    }
    public void setFollower_id(int follower_id) {
        this.follower_id = follower_id;
    }

    // 팔로잉 닉네임 받아오기
    public String getFollowing_nickname() {
        return following_nickname;
    }
    public void setFollowing_nickname(String following_nickname) {
        this.following_nickname = following_nickname;
    }

    // 팔로워 닉네임 받아오기
    public String getFollower_nickname() {
        return follower_nickname;
    }
    public void setFollower_nickname(String follower_nickname) {
        this.follower_nickname = follower_nickname;
    }

    public boolean isFollows() {
        return follows;
    }
    public void setFollows(boolean follows) {
        this.follows = follows;
    }

    @Override
    public String toString() {
        return "FollowDto [follow_id=" + follow_id + ", following_id=" + following_id + ", follower_id=" + follower_id
                + ", following_nickname=" + following_nickname + ", follower_nickname=" + follower_nickname + ", follows=" + follows + "]";
    }
}