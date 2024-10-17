package com.retrowalk.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("WHOLESALE")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WholesaleBusiness extends Business {

    @Column(name = "wholesale_license", nullable = true)
    private String wholesaleLicense;

}

