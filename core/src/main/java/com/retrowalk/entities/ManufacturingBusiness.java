package com.retrowalk.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("MANUFACTURING")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ManufacturingBusiness extends Business {

    @Column(name = "factory_location", nullable = true)
    private String factoryLocation;

}
