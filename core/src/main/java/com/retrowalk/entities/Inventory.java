package com.retrowalk.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Inventory of a product that available for purchase.
 */
@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "inventory")
public class Inventory extends AuditCommonBaseModel {

    /**
     * The product this inventory is of.
     * -- GETTER --
     * Gets the product.
     * <p>
     * <p>
     * -- SETTER --
     * Sets the product.
     *
     * @return The product.
     * @param product The product to be set.
     */
    @JsonIgnore
    @OneToOne(optional = false, orphanRemoval = true)
    @JoinColumn(name = "product_id", nullable = false, unique = true)
    private Product product;
    /**
     * The quantity in stock.
     * -- GETTER --
     * Gets the quantity in stock.
     * <p>
     * <p>
     * -- SETTER --
     * Sets the quantity in stock of the product.
     *
     * @return The quantity.
     * @param quantity The quantity to be set.
     */
    @Column(name = "quantity", nullable = false)
    private Integer quantity;
}