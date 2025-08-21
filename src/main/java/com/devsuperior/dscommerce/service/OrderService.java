package com.devsuperior.dscommerce.service;

import com.devsuperior.dscommerce.dto.OrderDTO;
import com.devsuperior.dscommerce.entity.*;
import com.devsuperior.dscommerce.exceptions.ResourceNotFoundException;
import com.devsuperior.dscommerce.repository.OrderItemRepository;
import com.devsuperior.dscommerce.repository.OrderRepository;
import com.devsuperior.dscommerce.repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final UserService userService;
    private final OrderItemRepository orderItemRepository;
    private final AuthService authService;

    public OrderService(OrderRepository orderRepository, UserService userService, ProductRepository productRepository, OrderItemRepository orderItemRepository,AuthService authService) {
        this.orderRepository = orderRepository;
        this.userService = userService;
        this.productRepository = productRepository;
        this.orderItemRepository = orderItemRepository;
        this.authService = authService;
    }

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id) {
        final var orderEntity = orderRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pedido não encontrado"));
        authService.validateSelfOrAdmin(orderEntity.getClient().getId());
        return new OrderDTO(orderEntity);
    }

    @Transactional
    public OrderDTO create(@Valid OrderDTO dto) {
        Order order = new Order();
        order.setMoment(Instant.now());
        order.setStatus(OrderStatus.WAITING_PAYMENT);
        User user = userService.authenticated();
        order.setCliente(user);

        for (var itemDto : dto.getItems()) {
            Product product = productRepository.getReferenceById(itemDto.getProductId());
            OrderItem item = new OrderItem();
            item.setProduct(product);
            item.setOrder(order);
            item.setQuantity(itemDto.getQuantity());
            item.setPrice(itemDto.getPrice());
            order.getItems().add(item);
        }
        orderRepository.save(order);
        orderItemRepository.saveAll(order.getItems());

        return new OrderDTO(order);
    }
}
