package com.example.ecommercebe.repository.user;

import com.example.ecommercebe.entity.user.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAddressRepository extends JpaRepository<Address, Long> {
}
