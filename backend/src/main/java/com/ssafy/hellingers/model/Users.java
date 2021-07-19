package com.ssafy.hellingers.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Clob;
import java.sql.Timestamp;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer Id;

    @Column(length = 45, name = "username")
    private String userName;

    @Column(length = 45, name = "email")
    private String email;

    @Column(length = 45, name = "nickname")
    private String nickname;

    @Column(length = 45, name = "categories")
    private String categories;

    @Column(name = "count")
    private Integer count;

    @Column(name = "comment_count")
    private Integer commentCount;

    @Column(name = "level")
    private Integer level;

    @Column(name = "introduce")
    private Clob introduce;

    @Column(name = "point")
    private int point;

    @Column(name = "dead")
    private int dead;

    @Column(name = "squat")
    private int squat;

    @Column(name = "bench")
    private int bench;

    @Column(name = "created_at")
    private Timestamp created_At;


}
