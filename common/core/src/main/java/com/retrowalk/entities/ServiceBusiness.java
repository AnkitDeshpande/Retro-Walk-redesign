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
@DiscriminatorValue("SERVICES")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceBusiness extends Business {

    @Column(name = "service_category", nullable = true)
    private String serviceCategory;

}
