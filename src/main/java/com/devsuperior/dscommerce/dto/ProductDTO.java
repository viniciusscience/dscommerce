package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entity.Category;
import com.devsuperior.dscommerce.entity.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

public class ProductDTO {
    private Long id;

    @Size(min = 3, max = 80, message = "Nome ter que ter entre 3 e 80 caracteres")
    @NotBlank(message = "Nome não pode ser vazio")
    private String name;
    @Size(min = 10, message = "Descrição precisa ter no mínimo 10 caracteres")
    @NotBlank(message = "Descrição não pode ser vazio")
    private String description;
    private String url;
    @Positive(message = "O preço deve ser positivo")
    private Double price;
    private String imgUrl;

    @NotEmpty(message = "Deve ter pelo menos uma categoria")
    private List<CategoriaDTO> categories = new ArrayList<>();

    public ProductDTO(Long id, String name, String description, String url, Double price, String imgUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.url = url;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    public ProductDTO() {
    }

    public ProductDTO(Product entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.price = entity.getPrice();
        this.imgUrl = entity.getImgUrl();
        for (Category category : entity.getCategories()) {
            categories.add(new CategoriaDTO(category));
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public List<CategoriaDTO> getCategories() {
        return categories;
    }
}
