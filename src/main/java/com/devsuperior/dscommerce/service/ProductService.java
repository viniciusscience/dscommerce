package com.devsuperior.dscommerce.service;

import com.devsuperior.dscommerce.dto.ProductDTO;
import com.devsuperior.dscommerce.entity.Product;
import com.devsuperior.dscommerce.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService implements BaseService<ProductDTO, ProductDTO> {

    private final ProductRepository productRepository;
    private final static ModelMapper modelMapper = new ModelMapper();

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    @Transactional
    public ProductDTO create(ProductDTO dto) {
        final var produtoEntityIn = modelMapper.map(dto, Product.class);
        final var produtoEntityOut = productRepository.save(produtoEntityIn);
        return modelMapper.map(produtoEntityOut, ProductDTO.class);
    }


    @Override
    @Transactional
    public ProductDTO update(Long id, ProductDTO dto) {
        var produtoEntityIn = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado"));

        produtoEntityIn.setDescription(dto.getDescription());
        produtoEntityIn.setPrice(dto.getPrice());
        produtoEntityIn.setName(dto.getName());
        produtoEntityIn.setImgUrl(dto.getImgUrl());

        var produtoEntityOut = productRepository.save(produtoEntityIn);

        return modelMapper.map(produtoEntityOut, ProductDTO.class);
    }

    @Override
    public ProductDTO delete(ProductDTO entity) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        final var produtoEntity = productRepository
                .findById(id).get();

        return modelMapper.map(produtoEntity, ProductDTO.class);
    }

    @Override
    public Page<ProductDTO> findAll(Pageable pageable) {
        return productRepository
                .findAll(pageable)
                .map(entity -> modelMapper.map(entity, ProductDTO.class));

    }
}
