package com.devsuperior.dscommerce.controller;

import com.devsuperior.dscommerce.dto.OrderDTO;
import com.devsuperior.dscommerce.dto.ProductDTO;
import com.devsuperior.dscommerce.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.findById(id));
    }

   @PostMapping
   @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_OPERATOR')")
   public ResponseEntity<OrderDTO> criarPedido(@Valid @RequestBody OrderDTO dto) {
       dto = orderService.create(dto);

       URI uri = ServletUriComponentsBuilder
               .fromCurrentRequest()
               .path("/{id}")
               .buildAndExpand(dto.getId())
               .toUri(); //

       return ResponseEntity.created(uri).body(orderService.create(dto));

    }

}
