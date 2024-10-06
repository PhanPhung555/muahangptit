package com.example.ecommercebe.repository.cart;

import com.example.ecommercebe.entity.cart.ShoppingCartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IShoppingCartItemRepository extends JpaRepository<ShoppingCartItem,Long> {
}
