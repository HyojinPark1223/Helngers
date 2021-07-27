package com.ssafy.hellingers.repository;

import com.ssafy.hellingers.model.Challenge;
import com.ssafy.hellingers.model.Medal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedalRepository extends JpaRepository<Medal, Long> {

}
