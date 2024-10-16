package com.retrowalk.entities;

import com.retrowalk.enums.AccountStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account extends AuditCommonBaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "store_name", nullable = false)
    private String storeName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "contact_number", nullable = false)
    private String contactNumber;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "business_id", referencedColumnName = "id")
    private Business business;

    @Column(name = "registration_date", nullable = false)
    private Date registrationDate;

    @Column(name = "last_login_date", nullable = true)
    private Date lastLoginDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "account_status", nullable = false)
    private AccountStatus accountStatus;
}
