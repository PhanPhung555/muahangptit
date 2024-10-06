package com.example.ecommercebe.entity.product;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "product_item")
public class ProductItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String nameSKU;

    Integer quantityInStock;

    Double price;

    @ManyToOne
    @JoinColumn(name = "product_id")
    Product product;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "item_variation_option",
            joinColumns = @JoinColumn(name = "product_item_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "variation_option_id",referencedColumnName = "id"))
    Set<ProductVariationOption> productVariationOptions;
}
