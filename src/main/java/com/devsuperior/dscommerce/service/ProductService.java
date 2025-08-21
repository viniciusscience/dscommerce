package com.devsuperior.dscommerce.service;

import com.devsuperior.dscommerce.dto.ProductDTO;
import com.devsuperior.dscommerce.entity.Category;
import com.devsuperior.dscommerce.entity.Product;
import com.devsuperior.dscommerce.execptions.ResourceNotFoundException;
import com.devsuperior.dscommerce.repository.CategoryRepository;
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
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {

        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    @Transactional
    public ProductDTO create(ProductDTO dto) {
        final var produtoEntityIn = modelMapper.map(dto, Product.class);

        for (var c : dto.getCategories()) {
            final var categoriaReference = categoryRepository.getReferenceById(c.getId());
            produtoEntityIn.getCategories().add(categoriaReference);

        }
        final var produtoEntityOut = productRepository.save(produtoEntityIn);

        return  new ProductDTO(produtoEntityOut);
    }


    @Override
    @Transactional
    public ProductDTO update(Long id, ProductDTO dto) {
        final var produtoEntityIn = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado"));

        produtoEntityIn.setDescription(dto.getDescription());
        produtoEntityIn.setPrice(dto.getPrice());
        produtoEntityIn.setName(dto.getName());
        produtoEntityIn.setImgUrl(dto.getImgUrl());

        final var produtoEntityOut = productRepository.save(produtoEntityIn);

        return modelMapper.map(produtoEntityOut, ProductDTO.class);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        final var produtoEntity = productRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado"));

        return new ProductDTO(produtoEntity);
    }

    @Override
    public Page<ProductDTO> findAll(Pageable pageable) {
        return productRepository
                .findAll(pageable)
                .map(entity -> modelMapper.map(entity, ProductDTO.class));
    }
}
