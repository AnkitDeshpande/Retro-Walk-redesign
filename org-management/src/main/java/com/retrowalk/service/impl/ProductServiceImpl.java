package com.retrowalk.service.impl;

import com.retrowalk.entities.Product;
import com.retrowalk.repository.ProductRepository;
import com.retrowalk.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service for handling product actions.
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    /**
     * The Product DAO.
     */
    private final ProductRepository productRepository;

    /**
     * Gets the all products available.
     *
     * @return The list of products.
     */
    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

}
