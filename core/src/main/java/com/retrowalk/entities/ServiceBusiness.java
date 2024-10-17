package com.retrowalk.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("SERVICES")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ServiceBusiness extends Business {

    @Column(name = "service_category", nullable = true)
    private String serviceCategory;

}
