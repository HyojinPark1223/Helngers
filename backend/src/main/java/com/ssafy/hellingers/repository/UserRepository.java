package com.ssafy.hellingers.repository;

import com.ssafy.hellingers.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>//부모클래스 User
{

    Optional<User> findByNickname(String nickname);
    Optional<User> findByEmail(String email);

}
