package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entity.User;

public class ClientDTO {

    private Long id;
    private String name;

    public ClientDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public ClientDTO(User entity) {
        this.id = entity.getId();
        this.name = entity.getName();
    }

    public ClientDTO() {
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }
}
