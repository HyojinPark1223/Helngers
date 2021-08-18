package com.ssafy.hellingers.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Data
@Table(name = "medals")
public class Medal {

    @Id // 기본키 (Primary Key)로 사용할 Value 값에 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키를 자동 생성하고자 할 때 설정.
    @Column(name = "id")
    private Long Id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "goal")
    private Integer goal;

    @Column(name = "level")
    private Integer level;

    @Column(name = "url")
    private String url;
}