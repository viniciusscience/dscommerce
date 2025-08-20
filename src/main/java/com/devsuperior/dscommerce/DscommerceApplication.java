package com.devsuperior.dscommerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class DscommerceApplication {
    
    public static void main(String[] args) {

        SpringApplication.run(DscommerceApplication.class, args);

    }

}
