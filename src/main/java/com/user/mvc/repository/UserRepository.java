package com.user.mvc.repository;

import com.user.mvc.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT u FROM users u WHERE u.username = :username")
    User findByUsername(@Param("username") String username);

    @Query(value = "UPDATE users u set u.username=:username, u.emailaddress=:emailaddress, u.password=:password WHERE u.id=:id")
    void update(Long id, String username, String emailaddress, String password);



}
