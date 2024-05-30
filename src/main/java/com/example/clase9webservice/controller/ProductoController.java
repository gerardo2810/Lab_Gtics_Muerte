package com.example.clase9webservice.controller;

import com.example.clase9webservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ProductoController {

    final ProductRepository productRepository;

    public ProductoController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
}
