package com.devsuperior.dscommerce.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BaseService<T, R> {

    R create(T entity);
    R update(T entity);
    R delete(T entity);
    R findById(Long id);
    Page<R> findAll(Pageable pageable);
}
