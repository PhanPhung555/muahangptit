package com.example.ecommercebe.repository.pay;

import com.example.ecommercebe.entity.payment.UserPaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserPaymentMethodRepository extends JpaRepository<UserPaymentMethod, Long> {
}
