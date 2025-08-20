package com.devsuperior.dscommerce.controller;

import com.devsuperior.dscommerce.dto.UserDto;
import com.devsuperior.dscommerce.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/me")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public UserDto getUserLogado() {
        return userService.getMe();
    }
}
