package com.devsuperior.dscommerce.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String authority;


    public Role(Long id, String authority) {
        this.id = id;
        this.authority = authority;
    }

    public Role() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(authority, role.authority);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(authority);
    }

    public String getAuthority() {
        return authority;
    }

    public Long getId() {
        return id;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
