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
@Table(name = "product_variation_option")
public class ProductVariationOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String valueVariationOption;

    @ManyToOne
    @JoinColumn(name = "id_product_variation")
    ProductVariation productVariation;

    @ManyToMany(mappedBy = "productVariationOptions")
    Set<ProductItem> productItems;
}
