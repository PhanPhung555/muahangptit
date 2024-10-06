package com.example.ecommercebe.service.role;

import com.example.ecommercebe.config.ModelMapperConfig;
import com.example.ecommercebe.entity.role.Role;
import com.example.ecommercebe.repository.role.IRoleRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@AllArgsConstructor
public class RoleService implements IRoleService{

     IRoleRepository roleRepository;

    @Override
    public boolean existsByName(String name) {
        return roleRepository.existsByName(name);
    }

    @Override
    public void saveRole(Role role) {
        roleRepository.save(role);
    }
}
