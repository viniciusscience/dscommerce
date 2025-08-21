package com.devsuperior.dscommerce.service;

import com.devsuperior.dscommerce.dto.OrderDTO;
import com.devsuperior.dscommerce.execptions.ResourceNotFoundException;
import com.devsuperior.dscommerce.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id) {
        final var orderEntity = orderRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pedido não encontrado"));

        return new OrderDTO(orderEntity);
    }
}
