package com.system.mobile_shopping.repo;

import com.system.mobile_shopping.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Integer> {
    @Query(value="select * from users where email=?1", nativeQuery = true)
    Optional<User> findByEmail(String email);
}
