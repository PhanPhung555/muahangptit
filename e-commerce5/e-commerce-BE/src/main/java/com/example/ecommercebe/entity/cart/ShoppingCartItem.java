package com.example.ecommercebe.entity.cart;

import com.example.ecommercebe.entity.product.ProductItem;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Entity
@Table(name = "Shopping_Cart_Item")
public class ShoppingCartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "shopping_cart_id")
    ShoppingCart shoppingCart;

    @ManyToOne
    @JoinColumn(name = "product_item_id")
    ProductItem productItem;

    int quantityCart;
}
