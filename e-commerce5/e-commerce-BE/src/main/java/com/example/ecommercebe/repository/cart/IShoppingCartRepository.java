package com.example.ecommercebe.repository.cart;

import com.example.ecommercebe.entity.cart.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
}
