package com.devsuperior.dscommerce.repository;

import com.devsuperior.dscommerce.entity.OrderItem;
import com.devsuperior.dscommerce.entity.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
}
