package com.example.ecommercebe.repository.role;

import com.example.ecommercebe.entity.role.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {

    boolean existsByName(String name);

    Set<Role> findByIdIn(Set<Long> ids);
}
