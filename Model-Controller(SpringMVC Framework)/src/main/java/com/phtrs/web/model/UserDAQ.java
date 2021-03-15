package com.phtrs.web.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserDAQ extends JpaRepository<User, Integer> {
    User findByUserName(String username);

    boolean existsByUserNameAndPassword(String username, String password);
    boolean existsByUserName(String username);
    @Query("Select u.password from User u where u.userName = :username")
    String findPasswordWithUserName(@Param("username")String username);
}
