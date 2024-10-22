package com.retrowalk.controller;

import com.retrowalk.entities.Product;
import com.retrowalk.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller to handle the creation, updating & viewing of products.
 */
@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    /**
     * The Product Service.
     */
    private final ProductService productService;

    /**
     * Gets the list of products available.
     *
     * @return The list of products.
     */
    @GetMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }

}
