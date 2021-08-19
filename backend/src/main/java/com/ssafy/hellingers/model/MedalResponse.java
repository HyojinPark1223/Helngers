package com.ssafy.hellingers.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Data
public class MedalResponse {

    Long medals_id;
    Long users_id;
    Integer present;

    public MedalResponse(Long mid, Long uid, int present){
        this.medals_id = mid;
        this.users_id = uid;
        this.present = present;
    }

}