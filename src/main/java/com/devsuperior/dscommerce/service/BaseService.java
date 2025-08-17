package com.devsuperior.dscommerce.service;

public interface BaseService<T, R> {

    R create(T entity);
    R update(T entity);
    R delete(T entity);
    R findById(Long id);
}
