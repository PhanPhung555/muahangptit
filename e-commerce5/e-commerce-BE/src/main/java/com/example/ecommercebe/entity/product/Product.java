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
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String productName;

    @Lob
    String productDescription;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    Set<ImageProduct> imageProducts;

    boolean isDelete;

    boolean producStatus;

    @ManyToOne
    @JoinColumn(name = "id_product_Category")
    ProductCategory productCategory;

}
