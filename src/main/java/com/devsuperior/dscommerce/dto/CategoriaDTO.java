package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entity.Category;

public class CategoriaDTO {
    private Long id;
    private String nome;

    public CategoriaDTO(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public CategoriaDTO() {

    }

    public CategoriaDTO(Category category) {
        this.id = category.getId();
        this.nome = category.getName();

    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

}
