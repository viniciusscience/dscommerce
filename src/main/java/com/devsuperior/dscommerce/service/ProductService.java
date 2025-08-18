package com.devsuperior.dscommerce.service;

import com.devsuperior.dscommerce.dto.ProductDTO;
import com.devsuperior.dscommerce.entity.Product;
import com.devsuperior.dscommerce.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService implements BaseService<Product, ProductDTO> {

    private final ProductRepository productRepository;
    private final static ModelMapper modelMapper = new ModelMapper();

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
       final var produtoEntity=  productRepository
                .findById(id).get();

        return modelMapper.map(produtoEntity, ProductDTO.class);
    }

    @Override
    public Page<ProductDTO> findAll(Pageable pageable) {
      return  productRepository
                .findAll(pageable)
                .map(entity-> modelMapper.map(entity, ProductDTO.class));

    }
}
