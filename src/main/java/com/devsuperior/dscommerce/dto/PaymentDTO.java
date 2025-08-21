package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entity.Payment;

import java.time.Instant;

public class PaymentDTO {
    private Long id;
    private Instant instant;


    public PaymentDTO(Long id, Instant instant) {
        this.id = id;
        this.instant = instant;
    }

    public PaymentDTO() {
    }

    public PaymentDTO(Payment entity) {
        this.id = entity.getId();
        this.instant = entity.getMoment();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getInstant() {
        return instant;
    }

    public void setInstant(Instant instant) {
        this.instant = instant;
    }
}
