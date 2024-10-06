package com.example.ecommercebe.service.product.category;

import com.example.ecommercebe.entity.product.ProductCategory;

public interface IProductCategoryService {

    void saveProductCategory(ProductCategory productCategory);

    boolean existsByName_product_category(String categoryName);
}
