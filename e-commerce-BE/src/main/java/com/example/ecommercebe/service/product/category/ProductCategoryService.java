package com.example.ecommercebe.service.product.category;

import com.example.ecommercebe.entity.product.ProductCategory;
import com.example.ecommercebe.repository.product.category.IProductCategoryRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@AllArgsConstructor
public class ProductCategoryService implements IProductCategoryService{

    IProductCategoryRepository iProductCategoryRepository;

    @Override
    public void saveProductCategory(ProductCategory productCategory) {
        iProductCategoryRepository.save(productCategory);
    }

    @Override
    public boolean existsByName_product_category(String name) {
        return true;
    }
}
