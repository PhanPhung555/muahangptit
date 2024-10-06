package com.example.ecommercebe.repository.shipping;

import com.example.ecommercebe.entity.shipping.ShippingMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IShippingMethodRepository extends JpaRepository<ShippingMethod, Long> {

    boolean existsByNameShippingMethod(String nameShippingMethod);

}
