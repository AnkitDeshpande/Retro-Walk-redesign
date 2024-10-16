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
@DiscriminatorValue("MANUFACTURING")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ManufacturingBusiness extends Business {

    @Column(name = "factory_location", nullable = true)
    private String factoryLocation;

}
