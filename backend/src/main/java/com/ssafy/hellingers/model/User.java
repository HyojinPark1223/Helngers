package com.ssafy.hellingers.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;


@Data // getter, setter...
@Entity
@Table(name = "user")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

//    @Column(name = "nickname")
//    private String name;

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "password", nullable = false)
    private String password;



    @Column(name = "categories")
    private String categories;


    @Column(name = "count")
    private int count;

    @Column(name = "comment_count")
    private int comment_count;


    @Column(name = "level")
    private int level;

    @Column(name = "introduce")
    private String introduce;

    @Column(name = "point")
    private int point;

    @Column(name = "dead")
    private int dead;

    @Column(name = "squat")
    private int squat;

    @Column(name = "bench")
    private int bench;


    @Column(name = "create_date")
    private LocalDateTime createDate;



    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;

}
