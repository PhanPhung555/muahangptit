package com.example.ecommercebe.repository.user;

import com.example.ecommercebe.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

    boolean existsByEmailUser(String email);

    boolean existsByUsername(String username);

    User findByEmailUser(String email);

    User findByUsername(String username);


}
