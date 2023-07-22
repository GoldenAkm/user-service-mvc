package com.user.mvc.repository;

import com.user.mvc.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    @Query(value = "UPDATE users u set u.username=:username, u.emailAddress=:emailAddress, u.password=:password WHERE u.id=:id")
    void update(Long id, String username, String emailAddress, String password);

}
