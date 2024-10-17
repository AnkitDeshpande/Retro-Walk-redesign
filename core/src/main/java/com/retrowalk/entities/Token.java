package com.retrowalk.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "token")
public class Token extends AuditCommonBaseModel {

    /**
     * token.
     */
    @Column(name = "token")
    private String token;

    /**
     * tokenType.
     */
    @Column(name = "token_type")
    private String tokenType;


    /**
     * commonUser.
     */
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
