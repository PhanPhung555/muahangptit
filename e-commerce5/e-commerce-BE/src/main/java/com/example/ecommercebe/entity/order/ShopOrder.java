package com.example.ecommercebe.entity.order;

import com.example.ecommercebe.entity.shipping.ShippingMethod;
import com.example.ecommercebe.entity.payment.UserPaymentMethod;
import com.example.ecommercebe.entity.user.Address;
import com.example.ecommercebe.entity.user.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "Shop_Order")
public class ShopOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    LocalDateTime orderDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne
    @JoinColumn(name = "payment_method_id")
    UserPaymentMethod userPaymentMethod;

    @ManyToOne
    @JoinColumn(name = "shipping_address")
    Address shippingAddress;

    @ManyToOne
    @JoinColumn(name = "shipping_method")
    ShippingMethod shippingMethod;

    @ManyToOne
    @JoinColumn(name = "oder_status")
    OrderStatus orderStatus;
}
