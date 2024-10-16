package com.retrowalk.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("WHOLESALE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WholesaleBusiness extends Business {

    @Column(name = "wholesale_license", nullable = true)
    private String wholesaleLicense;

}

