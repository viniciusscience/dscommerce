package com.devsuperior.dscommerce.entity;

import jakarta.persistence.*;

import java.time.Instant;
@Entity
@Table(name = "tb_payment")
public class Payment {

    @Id
    private Long id;

    @OneToOne
    @MapsId
    private Order order;

    private Instant moment;

    public Payment(Long id, Order order, Instant moment) {
        this.id = id;
        this.order = order;
        this.moment = moment;
    }

    public Payment() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }
}
