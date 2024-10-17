package com.retrowalk.entities;

import jakarta.persistence.*;
import lombok.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "addresses")
public class Address extends AuditCommonBaseModel {

    /**
     * Street address.
     */
    @Column(name = "street", nullable = false, length = 150)
    private String street;

    /**
     * City name.
     */
    @Column(name = "city", nullable = false, length = 100)
    private String city;

    /**
     * State name.
     */
    @Column(name = "state", nullable = false, length = 100)
    private String state;

    /**
     * Country name.
     */
    @Column(name = "country", nullable = false, length = 100)
    private String country;

    /**
     * ZIP or postal code.
     */
    @Column(name = "zip_code", nullable = false, length = 20)
    private String zipCode;

    /**
     * The user associated with this address (many-to-one relationship).
     */
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
