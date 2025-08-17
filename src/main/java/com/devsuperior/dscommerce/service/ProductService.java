package com.devsuperior.dscommerce.service;

import com.devsuperior.dscommerce.dto.ProductDTO;
import com.devsuperior.dscommerce.entity.Product;
import com.devsuperior.dscommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService implements BaseService<Product, ProductDTO> {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public ProductDTO create(Product entity) {
        return null;
    }

    @Override
    public ProductDTO update(Product entity) {
        return null;
    }

    @Override
    public ProductDTO delete(Product entity) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        return productRepository
                .findById(id)
                .map(ProductDTO::new).get();
    }
}
