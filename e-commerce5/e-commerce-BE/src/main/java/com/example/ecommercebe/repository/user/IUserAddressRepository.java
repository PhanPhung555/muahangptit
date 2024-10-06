package com.example.ecommercebe.repository.user;

import com.example.ecommercebe.entity.user.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserAddressRepository extends JpaRepository<UserAddress, Long> {
}
