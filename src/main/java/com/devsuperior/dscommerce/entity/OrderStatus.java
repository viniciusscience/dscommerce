package com.devsuperior.dscommerce.entity;

public enum OrderStatus {
    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);


    OrderStatus(int i) {
    }
}
