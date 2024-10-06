package com.example.ecommercebe.config;

import com.example.ecommercebe.entity.product.ProductCategory;
import com.example.ecommercebe.entity.role.Role;
import com.example.ecommercebe.entity.shipping.ShippingMethod;
import com.example.ecommercebe.repository.product.category.IProductCategoryRepository;
import com.example.ecommercebe.repository.shipping.IShippingMethodRepository;
import com.example.ecommercebe.service.role.IRoleService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@AllArgsConstructor
@Configuration
public class DataAddedAutomatically implements ApplicationListener<ContextRefreshedEvent> {

    IRoleService iRoleService;

    IProductCategoryRepository iProductCategoryRepository;

    IShippingMethodRepository iShippingMethodRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if(!iRoleService.existsByName("ADMIN")){
            Role role = new Role().builder()
                    .name("ADMIN")
                    .build();
            iRoleService.saveRole(role);
        }
        if(!iRoleService.existsByName("USER")){
            Role role = new Role().builder()
                    .name("USER")
                    .build();
            iRoleService.saveRole(role);
        }

        if(!iProductCategoryRepository.existsByNameProductCategory("Giày")){
            ProductCategory productCategory = new ProductCategory().builder()
                    .nameProductCategory("Giày")
                    .build();
            iProductCategoryRepository.save(productCategory);
        }

        if(!iProductCategoryRepository.existsByNameProductCategory("Túi xách")){
            ProductCategory productCategory = new ProductCategory().builder()
                    .nameProductCategory("Túi xách")
                    .build();
            iProductCategoryRepository.save(productCategory);
        }

        if(!iProductCategoryRepository.existsByNameProductCategory("Giao hàng tiết kiệm")){
            ShippingMethod shippingMethod = new ShippingMethod().builder()
                    .nameShippingMethod("Giao hàng tiết kiệm")
                    .priceShippingMethod(17000)
                    .build();
            iShippingMethodRepository.save(shippingMethod);
        }
        if(!iProductCategoryRepository.existsByNameProductCategory("Giao hàng nhanh")){
            ShippingMethod shippingMethod = new ShippingMethod().builder()
                    .nameShippingMethod("Giao hàng nhanh")
                    .priceShippingMethod(27000)
                    .build();
            iShippingMethodRepository.save(shippingMethod);
        }
    }
}
