package com.ssafy.hellingers.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ssafy.hellingers.dto.FollowDto;
import com.ssafy.hellingers.service.FollowService;

// import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/account")
public class AccountController {
    final String S = "SUCCESS";
    final String F = "FAIL";

    @Autowired
    private FollowService followService;
    public static final Logger logger = LoggerFactory.getLogger(AccountController.class);

    //팔로우(맞팔)
    @PostMapping("/follow")
    public FollowDto follow(@RequestBody FollowDto followDto) throws Exception {

        int following_id = followDto.getFollow_id();
        int follower_id = followDto.getFollower_id();

        // 맞팔 여부 확인
        int check = followService.checkFollows(followDto);
        System.out.println("맞팔 체크 결과 : "+check);
        if(check > 0) { // 맞팔 결과 저장
            // 한 명이 팔로우 한 것을 1로 삽입후,
            // 기존 follower -> following의 맞팔도 1로 변경하고 맞팔 아니면 follows를 0으로
            followService.willFollows(followDto);
            followService.roundFollows(followDto);
        }else { //맞팔 아닐 때
            followService.onewayFollows(followDto);
        }

        return followDto;
    }

    // 언팔하기
    @PostMapping("/unfollow")
    public FollowDto unfollow(@RequestBody FollowDto followDto) throws Exception {

        int following_id = followDto.getFollow_id();
        int follower_id = followDto.getFollower_id();
        boolean follows = followDto.isFollows();

        if(follows) { //서로 맞팔이면 내 계정은 팔로우 삭제, 상대는 맞팔 -> 그냥 팔로우로 수정해줘야함.
            followService.deleteFollows(followDto);
        }

        followService.unfollow(followDto);
        return followDto;
    }

    @PostMapping("/following/{following_id}")
    public List<FollowDto> following(@PathVariable int following_id)throws Exception{
        List<FollowDto> following = new ArrayList<>();
        following = followService.followingList(following_id);
        return following;
    }

    @PostMapping("/follower/{follower_id}")
    public List<FollowDto> follower(@PathVariable int follower_id)throws Exception{
        List<FollowDto> follower = new ArrayList<>();
        follower = followService.followerList(follower_id);

        return follower;
    }

}