package com.retrowalk.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * A product available for purchasing.
 */
@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
public class Product extends AuditCommonBaseModel {

    /**
     * The name of the product.
     */
    @Column(name = "name", nullable = false, unique = true)
    private String name;
    /**
     * The short description of the product.
     */
    @Column(name = "short_description", nullable = false)
    private String shortDescription;
    /**
     * The long description of the product.
     */
    @Column(name = "long_description")
    private String longDescription;
    /**
     * The price of the product.
     */
    @Column(name = "price", nullable = false)
    private Double price;
    /**
     * The inventory of the product.
     */
    @OneToOne(mappedBy = "product", cascade = CascadeType.REMOVE, optional = false, orphanRemoval = true)
    private Inventory inventory;

}