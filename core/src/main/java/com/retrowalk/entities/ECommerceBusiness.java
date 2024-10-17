package com.retrowalk.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("ECOMMERCE")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ECommerceBusiness extends Business {

    @Column(name = "platform_url", nullable = true)
    private String platformUrl;

}
