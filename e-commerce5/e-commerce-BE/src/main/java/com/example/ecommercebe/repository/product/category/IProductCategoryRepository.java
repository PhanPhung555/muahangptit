package com.example.ecommercebe.repository.product.category;

import com.example.ecommercebe.entity.product.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductCategoryRepository extends JpaRepository<ProductCategory,Long> {

    boolean existsByNameProductCategory(String nameProductCategory);
}
