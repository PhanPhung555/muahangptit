package com.example.ecommercebe.repository.pay;

import com.example.ecommercebe.entity.payment.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPaymentTypeRrpository extends JpaRepository<PaymentType, Long> {
}
