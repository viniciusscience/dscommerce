package com.devsuperior.dscommerce.controller;

import com.devsuperior.dscommerce.dto.ProductDTO;
import com.devsuperior.dscommerce.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductDTO> create(@RequestBody ProductDTO dto) {
        dto = productService.create(dto);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(dto.getId()).toUri();

        return ResponseEntity.created(uri).body(productService.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.findById(id));
    }

    @GetMapping
    public ResponseEntity<Page<ProductDTO>> findByAll(Pageable pageable) {
        return ResponseEntity.ok(productService.findAll(pageable));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> atualizar(@PathVariable Long id, @RequestBody ProductDTO dto) {
        dto = productService.update(id, dto);
        return ResponseEntity.ok(productService.create(dto));
    }
}
