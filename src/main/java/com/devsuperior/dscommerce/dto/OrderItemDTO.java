package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entity.OrderItem;

public class OrderItemDTO {

    private Long productId;
    private String nome;
    private Double price;
    private Integer quantity;

    public OrderItemDTO() {}

    public OrderItemDTO(Long productId, String nome, Double price, Integer quantity) {
        this.productId = productId;
        this.nome = nome;
        this.price = price;
        this.quantity = quantity;
    }

    public OrderItemDTO(OrderItem entity){
        this.productId = entity.getProduct().getId();
        this.nome = entity.getProduct().getName();
        this.price = entity.getProduct().getPrice();
        this.quantity = entity.getQuantity();
    }


    public Integer getQuantity() {
        return quantity;
    }

    public Double getPrice() {
        return price;
    }

    public String getNome() {
        return nome;
    }

    public Long getProductId() {
        return productId;
    }
}
