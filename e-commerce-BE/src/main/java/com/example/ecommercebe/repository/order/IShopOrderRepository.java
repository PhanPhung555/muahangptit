package com.example.ecommercebe.repository.order;

import com.example.ecommercebe.entity.order.ShopOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IShopOrderRepository extends JpaRepository<ShopOrder, Long> {
}
