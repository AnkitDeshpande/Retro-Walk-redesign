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
@DiscriminatorValue("RETAIL")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RetailBusiness extends Business {

    @Column(name = "retail_chain_name", nullable = true)
    private String retailChainName;

}
