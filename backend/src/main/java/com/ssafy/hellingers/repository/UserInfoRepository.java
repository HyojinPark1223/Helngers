package com.ssafy.hellingers.repository;

import com.ssafy.hellingers.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserInfoRepository extends JpaRepository<Users, Long> {

    List<Users> findAll();
}
