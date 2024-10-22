package com.retrowalk.repository;

import com.retrowalk.entities.Product;
import org.springframework.data.repository.ListCrudRepository;

/**
 * Data Access Object for accessing Product data.
 */
public interface ProductRepository extends ListCrudRepository<Product, Long> {
}
