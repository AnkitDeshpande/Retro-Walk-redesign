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
@DiscriminatorValue("ECOMMERCE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ECommerceBusiness extends Business {

    @Column(name = "platform_url", nullable = true)
    private String platformUrl;

}
