package com.ssafy.hellingers.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class FollowDto {
    private int from_id;  // 팔로우 거는 사람(following)
    private int to_id;   //팔로우 당한 사람(follower)
    private boolean follows;  // 맞팔여부

    @Override
    public String toString() {
        return "FollowDto{" +
                "from_id=" + from_id +
                ", to_id=" + to_id +
                ", follows=" + follows +
                '}';
    }
}