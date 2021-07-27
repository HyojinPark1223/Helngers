package com.ssafy.hellingers.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class Account {
    @Id // 기본키 (Primary Key)로 사용할 Value 값에 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키를 자동 생성하고자 할 때 설정.
    @Column(name = "id")
    private Long Id;

    @Column(length = 45, name = "username")
    private String userName;

    @Column(length = 45, name = "email", nullable = false)
    private String email;

    @Column(length = 45, name = "password", nullable = false)
    private String password;

    @Column(length = 45, name = "nickname", nullable = false)
    private String nickname;

    @Column(length = 45, name = "categories")
    private String categories;

    @Column(name = "count")
    private Integer count;

    @Column(name = "comment_count")
    private Integer commentCount;

    @Column(name = "level")
    private Integer level;

    @Column(length = 300, name = "introduce")
    private String introduce;

    @Column(name = "point")
    private int point;

    @Column(name = "dead")
    private int dead;

    @Column(name = "squat")
    private int squat;

    @Column(name = "bench")
    private int bench;

    @CreationTimestamp // 해당 Object가 저장될 때 시간값(Timestamp)를 자동으로 생성하여 넣어준다. > INSERT시 동작.
    @Column(name = "created_at")
    private Date created_At;

}
