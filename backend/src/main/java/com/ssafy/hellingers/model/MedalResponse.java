package com.ssafy.hellingers.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Data
@Table
public class MedalResponse {

    private String title;

    private String content;

    private Integer goal;

    private Integer level;

    private String url;

    private Integer present;

//    private boolean isAchieve;


}