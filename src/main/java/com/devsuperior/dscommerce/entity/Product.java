package com.devsuperior.dscommerce.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tb_product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String url;

    private Double price;

    private String imgUrl;

    @OneToMany(mappedBy = "id.product")
    private Set<OrderItem> items = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "tb_product_category",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<Category>();


    public Product() {
    }

    public Product(Long id, String name, String description, String url, Double price, String imgUrl,Set<OrderItem> items) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.url = url;
        this.price = price;
        this.imgUrl = imgUrl;
        this.items = items;
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

    public Long getId() {
        return id;
    }
    public List<Order> getOrders() {
        return items.stream().map(OrderItem::getOrder).toList();
    }

    public Set<OrderItem> getItems() {
        return items;
    }
    public Set<Category> getCategories() {
        return categories;
    }
}
