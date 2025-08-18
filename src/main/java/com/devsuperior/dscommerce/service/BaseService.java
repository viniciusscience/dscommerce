package com.devsuperior.dscommerce.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BaseService<T, R> {

    R create(T entity);

    R update(Long id, T entity);

    void delete(Long id);

    R findById(Long id);

    Page<R> findAll(Pageable pageable);
}
