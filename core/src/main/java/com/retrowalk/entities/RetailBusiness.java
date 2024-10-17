package com.retrowalk.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("RETAIL")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RetailBusiness extends Business {

    @Column(name = "retail_chain_name", nullable = true)
    private String retailChainName;

}
