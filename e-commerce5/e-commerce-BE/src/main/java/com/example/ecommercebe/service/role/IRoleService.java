package com.example.ecommercebe.service.role;

import com.example.ecommercebe.entity.role.Role;

public interface IRoleService {

    boolean existsByName(String name);

    void saveRole(Role role);
}
